package com.danimota.encurtador.feature

sealed class ScreenRoute(val route: String) {
    object Login : ScreenRoute("login")
    object Home : ScreenRoute("home")
}