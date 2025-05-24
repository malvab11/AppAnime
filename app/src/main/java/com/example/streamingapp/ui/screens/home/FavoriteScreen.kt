package com.example.streamingapp.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.streamingapp.ui.screens.commons.CommonText

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier, padding: PaddingValues) {

    Box(modifier = modifier
        .fillMaxSize()
        .padding(padding), contentAlignment = Alignment.Center) {
        CommonText(text = "Tu Lista está Vacía", fontSize = 25)
    }

}