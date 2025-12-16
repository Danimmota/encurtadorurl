package com.danimota.encurtador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danimota.encurtador.ui.theme.EncurtadorTheme
import com.danimota.encurtador.ui.theme.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EncurtadorTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MainScreen()
        }
    }
}


// Preview para a tela completa, facilitando o desenvolvimento
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EncurtadorTheme {
        AppContent()
    }
}
