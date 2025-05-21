package com.example.streamingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streamingapp.data.Screens
import com.example.streamingapp.ui.screens.home.HomeScreen
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel
import com.example.streamingapp.ui.screens.init.LoginScreen
import com.example.streamingapp.ui.screens.init.PresentationScreen
import com.example.streamingapp.ui.screens.init.RegisterScreen
import com.example.streamingapp.ui.screens.init.SplashScreen
import com.example.streamingapp.ui.screens.init.viewModels.SplashScreenViewModel

@Composable
fun ScreenController(
    splashScreenViewModel: SplashScreenViewModel,
    animesViewModel: AnimesViewModel
) {

    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Screens.SplashScreen.ruta
    ) {
        composable(Screens.SplashScreen.ruta) {
            SplashScreen(
                navController = navigationController,
                splashScreenViewModel = splashScreenViewModel
            )
        }
        composable(Screens.PresentationScreen.ruta) {
            PresentationScreen(navController = navigationController)
        }
        composable(Screens.LoginScreen.ruta) {
            LoginScreen(navController = navigationController)
        }
        composable(Screens.RegisterScreen.ruta) {
            RegisterScreen(navController = navigationController)
        }
        composable("homeScreen") {
            HomeScreen(animesViewModel = animesViewModel)
        }
    }
}