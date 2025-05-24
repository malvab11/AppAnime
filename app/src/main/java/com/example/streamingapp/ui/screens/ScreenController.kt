package com.example.streamingapp.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streamingapp.data.Screens
import com.example.streamingapp.ui.screens.home.HomeScreen
import com.example.streamingapp.ui.screens.home.animeScreens.DetailViewModel
import com.example.streamingapp.ui.screens.home.animeScreens.detailScreens.AnimeDetailScreen
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel
import com.example.streamingapp.ui.screens.init.LoginScreen
import com.example.streamingapp.ui.screens.init.PresentationScreen
import com.example.streamingapp.ui.screens.init.RegisterScreen
import com.example.streamingapp.ui.screens.init.SplashScreen
import com.example.streamingapp.ui.screens.init.viewModels.SplashScreenViewModel

@Composable
fun ScreenController(
    splashScreenViewModel: SplashScreenViewModel,
    animesViewModel: AnimesViewModel,
    animeDetailViewModel: DetailViewModel
) {

    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Screens.HomeScreen.ruta
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
        composable(Screens.HomeScreen.ruta) {
            HomeScreen(navController = navigationController, animesViewModel = animesViewModel)
        }
        composable(Screens.AnimeDetailScreen.ruta) { datos ->
            val id = datos.arguments!!.getString("animeId")
            AnimeDetailScreen(animeDetailViewModel = animeDetailViewModel, animeId = id!!.toInt())
        }
    }
}