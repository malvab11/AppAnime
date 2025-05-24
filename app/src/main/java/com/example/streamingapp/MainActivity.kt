package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.streamingapp.ui.screens.ScreenController
import com.example.streamingapp.ui.screens.home.animeScreens.DetailViewModel
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel
import com.example.streamingapp.ui.screens.init.viewModels.SplashScreenViewModel
import com.example.streamingapp.ui.theme.StreamingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()
    private val animesViewModel: AnimesViewModel by viewModels()
    private val animeDetailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            StreamingAppTheme {
                ScreenController(
                    splashScreenViewModel = splashScreenViewModel,
                    animesViewModel = animesViewModel,
                    animeDetailViewModel = animeDetailViewModel
                )
            }
        }
    }
}
