package com.danimota.encurtador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danimota.encurtador.feature.ScreenRoute
import com.danimota.encurtador.feature.home.HomeScreen
import com.danimota.encurtador.feature.login.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = ScreenRoute.Login.route
            ){
                composable(ScreenRoute.Login.route) {
                    LoginScreen(
                        navController = navController
                    )
                }

                composable(ScreenRoute.Home.route) {
                    HomeScreen()
                }
            }
//            EncurtadorTheme {
//                LoginScreen()
//
//            }
        }
    }
}
