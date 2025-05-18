package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.streamingapp.ui.screens.home.HomeScreen
import com.example.streamingapp.ui.screens.home.SearchAnimeScreen
import com.example.streamingapp.ui.screens.home.viewModels.HomeViewModel
import com.example.streamingapp.ui.theme.StreamingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StreamingAppTheme {
//                LoadingScreen()
//                PresentationScreen()
//                LoginScreen()
//                RegisterScreen()
                HomeScreen(homeViewModel = homeViewModel)
//                SearchAnimeScreen()
            }
        }
    }
}
