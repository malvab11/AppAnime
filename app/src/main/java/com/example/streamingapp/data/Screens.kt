package com.example.streamingapp.data

sealed class Screens (val ruta: String) {
    data object SplashScreen : Screens ("splashScreen")
    data object PresentationScreen : Screens ("presentationScreen")
    data object LoginScreen : Screens ("loginScreen")
    data object RegisterScreen : Screens ("registerScreen")
    data object HomeScreen : Screens ("homeScreen")
    data object SearchAnimeScreen : Screens ("searchAnimeScreen")
}