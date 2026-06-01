package com.danimota.encurtador.feature.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.danimota.encurtador.feature.ScreenRoute


@Composable
fun LoginScreen(
    navController: NavController
) {
    LoginView(
        onNavigateToHome = {
            navController.navigate(ScreenRoute.Home.route)
        }
    )
}
