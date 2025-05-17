package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.streamingapp.screens.LoginScreen
import com.example.streamingapp.screens.RegisterScreen
import com.example.streamingapp.ui.theme.StreamingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StreamingAppTheme {
//                LoadingScreen()
//                PresentationScreen()
//                LoginScreen()
                RegisterScreen()
            }
        }
    }
}
