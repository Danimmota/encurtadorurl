package com.danimota.encurtador.ui.theme

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.danimota.encurtador.data.local.database.DatabaseProvider
import com.danimota.encurtador.data.local.entity.LinkEntity
import com.danimota.encurtador.data.remote.model.ShortenRequest
import com.danimota.encurtador.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MainScreen() {
    var urlValue by remember { mutableStateOf("") }
    var lastUrlEncurted by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    // Habilita o botão de copiar apenas se houver uma URL encurtada disponível
    val isCopyEnabled = lastUrlEncurted != null

    val linkDao = remember { DatabaseProvider.getInstance(context).linkDAO() }
    val recentLinks by linkDao.getAllLinks().collectAsState(initial = emptyList())

    // Column principal que organiza toda a tela
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HeaderComponent()

        UrlInputWithActions(
            urlValue = urlValue,
            isLoading = isLoading,
            isCopyEnabled = isCopyEnabled,
            onUrlChange = { newUrl -> urlValue = newUrl },
            onShortenClick = {
                // A lógica da coroutine agora vive aqui, no Composable pai!
                coroutineScope.launch {
                    lastUrlEncurted = null
                    isLoading = true
                    try {
                        val response = RetrofitInstance.api.shortenUrl(
                            ShortenRequest(url = urlValue)
                        )
                        val successLog = "URL encurtada com sucesso: ${response.alias}"
                        Log.d("UrlShortener", successLog)
                        lastUrlEncurted = response.links.short // O resultMessage será usado no componente da lista

                        Toast.makeText(context, "URL encurtada com sucesso!", Toast.LENGTH_SHORT).show()

                        // Salva a URL encurtada no banco de dados local
                        withContext(Dispatchers.IO) {
                            linkDao.insertLink(
                                LinkEntity(
                                    alias = response.alias,
                                    originalUrl = urlValue,
                                    shortUrl = response.links.short,
                                    // Data e hora atual no formato timestamp
                                    createdAt = System.currentTimeMillis()
                                )
                            )
                        }
                    } catch (e: Exception) {
                        val errorLog = "Falha ao encurtar URL: ${e.message}"
                        Log.e("UrlShortener", errorLog)
                        // A mensagem de erro também pode ser usada para exibição
                        Toast.makeText(context, "Erro: ${e.message}", Toast.LENGTH_LONG).show()
                    } finally {
                        isLoading = false
                    }
                }
            },
            onCopyClick = {
                // Lógica para copiar o link
                lastUrlEncurted?.let { message ->
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Shortened URL", message)
                    clipboard.setPrimaryClip(clip)
                }

                Toast.makeText(context, "Link copiado para a área de transferência!", Toast.LENGTH_SHORT).show()

            }
        )

        ShortenedUrlsList(recentLinks)
    }
}

@Composable
private fun HeaderComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 24.dp, 16.dp, 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Encurtador de URLs",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Encurte suas URLs de forma rápida e fácil!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun UrlInputWithActions(

    urlValue: String,
    isLoading: Boolean,
    isCopyEnabled: Boolean,

    onUrlChange: (String) -> Unit,
    onShortenClick: () -> Unit,
    onCopyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Insira a URL que deseja encurtar:",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        TextField(
            value = urlValue,
            onValueChange = onUrlChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Digite a URL aqui") },

        )

        Button(
            onClick = onShortenClick,
            enabled = urlValue.isNotBlank() && !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text(text = "Encurtar URL")
            }
        }

        Button(

            enabled = isCopyEnabled,
            onClick = onCopyClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
        ) {
            Text(text = "Copiar Link Encurtado")
        }
    }
}

@Composable
private fun ShortenedUrlsList(recentLinks: List<LinkEntity>) {

    // Busca no banco de dados local as URLs encurtadas

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Histórico de URLs",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(recentLinks) { url -> UrlItem(linkEntity = url) }
        }
    }
}

@Composable
private fun UrlItem(linkEntity: LinkEntity) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Alias: ${linkEntity.alias}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Link encurtado: ${linkEntity.shortUrl}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Original: ${linkEntity.originalUrl}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                maxLines = 1 // Evita que URLs muito longas quebrem o layout
            )
        }
    }
}
