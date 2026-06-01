package com.danimota.encurtador.feature.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danimota.encurtador.R
import com.danimota.encurtador.ui.theme.Background
import com.danimota.encurtador.ui.theme.DarkGray
import com.danimota.encurtador.ui.theme.LightGray
import com.danimota.encurtador.ui.theme.Purple40
import com.danimota.encurtador.ui.theme.Purple80

@Composable
fun LoginView( onNavigateToHome: () -> Unit) {
    LoginLayout(
        onNavigateToHome = onNavigateToHome
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(
    onNavigateToHome: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        contentWindowInsets = WindowInsets.navigationBars,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(56.dp),
                containerColor = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Não tem uma conta?",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = DarkGray
                    )
                    Text(
                        text = "Cadastre-se aqui.",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Purple40
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Background)
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding()
                .verticalScroll(rememberScrollState()),
            ) {
            Column(
                modifier = Modifier.weight(0.3f).fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(160.dp),
                    painter = painterResource(R.drawable.encurtador_link),
                    contentDescription = null
                )
            }
            Card(
                modifier = Modifier.weight(0.95f),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.White)
                        .padding(top = 32.dp, start = 24.dp, end = 24.dp),
                    verticalArrangement = Arrangement.Top
                    ) {
                    Text(
                        text = "Bem vindo ao Encurta Links!",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp, bottom = 24.dp),
                        text = "Seu encurtador de links favorito.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                        text = "Email",
                        fontSize = 16.sp,
                        color = DarkGray,
                        fontWeight = FontWeight.Medium
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(
                                text = "Ex: joao@email.com",
                                color = LightGray
                            )
                        },
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(focusDirection = FocusDirection.Down)
                            }
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = LightGray,
                            focusedBorderColor = Purple80
                        )
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                        text = "Senha",
                        fontSize = 16.sp,
                        color = DarkGray,
                        fontWeight = FontWeight.Medium
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text(
                                text = "Digite sua senha",
                                color = LightGray
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done,
                        ),
                        trailingIcon = {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        passwordVisibility = !passwordVisibility
                                    },
                                painter =  painterResource(id =  if (passwordVisibility)
                                    R.drawable.ic_visibility_off
                                else
                                    R.drawable.ic_eye),
                                tint = if (passwordVisibility) LightGray else Purple80,
                                contentDescription = null,
                            )
                        },
                        visualTransformation =
                            if (passwordVisibility)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = LightGray,
                            focusedBorderColor = Purple80
                        ),
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.End,
                        text = "Esqueceu sua senha?",
                        fontSize = 16.sp,
                        color = Purple40,
                        fontWeight = FontWeight.Medium
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(2.dp,   Purple40),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        ),
                        onClick = {
                            focusManager.clearFocus()
                            onNavigateToHome()
                        }
                    ) {
                        Text(
                            text = "Entrar",
                            fontSize = 18.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        HorizontalDivider(
                            modifier = Modifier.weight(1.0f),
                            thickness = 2.dp,
                            color = LightGray
                        )
                        Text(
                            text = "CONTINUE COM",
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontSize = 14.sp,
                            color = LightGray
                        )
                        HorizontalDivider(
                            modifier = Modifier.weight(1.0f),
                            thickness = 2.dp,
                            color = LightGray
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        OutlinedButton(
                            onClick = {
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = LightGray,
                                containerColor = Color.White
                            ),
                            border = BorderStroke(1.dp, LightGray)
                        ) {
                            Text(
                                text = "Google"
                            )
                        }
                        OutlinedButton(
                            onClick = {
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = LightGray,
                                containerColor = Color.White
                            ),
                            border = BorderStroke(1.dp, LightGray)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_mac_os),
                                contentDescription = "Ícone Apple",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(
                                Modifier.size(ButtonDefaults.IconSpacing)
                            ) // 2. Espaçador para separar ícone e texto
                            Text(
                                text = "Apple"
                            )
                        }
                    }

                }
            }

        }

    }

}

@Preview
@Composable
fun PreviewLogin() {
    LoginLayout(onNavigateToHome = {})
}