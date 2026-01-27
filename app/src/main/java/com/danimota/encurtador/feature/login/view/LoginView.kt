package com.danimota.encurtador.feature.login.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danimota.encurtador.R
import com.danimota.encurtador.ui.theme.Background
import com.danimota.encurtador.ui.theme.DarkGray
import com.danimota.encurtador.ui.theme.LightGray
import com.danimota.encurtador.ui.theme.Primary
import com.danimota.encurtador.ui.theme.Purple80


@Composable
fun LoginView() {
    LoginLayout()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(8.dp),
                title = {
                    Text(
                        text = "Login"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Background
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(56.dp),
                containerColor = Background
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account?",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = LightGray
                    )
                    Text(
                        text = "Sign Up?",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Purple80
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),

            ) {
            Text(
                text = "Encurta Links",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGray
            )
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                text = "Seu encurtador de links favorito",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
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
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(
                        text = "Ex: name@exemple.com",
                        color = LightGray
                    )
                },
                value = "",
                onValueChange = {
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = LightGray,
                    focusedBorderColor = Primary
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
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_lock),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = LightGray
                    )
                },
                value = "",
                onValueChange = {
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = LightGray,
                    focusedBorderColor = Primary
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                textAlign = TextAlign.End,
                text = "Forgot Password?",
                fontSize = 16.sp,
                color = LightGray,
                fontWeight = FontWeight.Medium
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple80
                ),
                onClick = {

                }
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding( 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1.0f),
                    thickness = 2.dp,
                    color = LightGray
                )
                Text(
                    text = "OR CONTINUE WITH",
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
                modifier = Modifier.fillMaxWidth().padding( 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                OutlinedButton(
                    onClick = {
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = LightGray,
                        containerColor = Background
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
                        containerColor = Background
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

@Preview
@Composable
fun PreviewLogin() {
    LoginLayout()
}