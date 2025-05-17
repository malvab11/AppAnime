package com.example.streamingapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.streamingapp.R
import com.example.streamingapp.screens.commons.CommonImage
import com.example.streamingapp.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.screens.commons.CommonSpacer
import com.example.streamingapp.screens.commons.CommonText
import com.example.streamingapp.screens.commons.CommonTextNameApp

@Composable
fun PresentationScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Fondo(modifier = Modifier.fillMaxSize())
        FondoDegradado()
        FooterPresentation()
    }
}

@Composable
fun FondoDegradado() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(0.1f),
                        Color.Black
                    )
                )
            )
    )
}

@Composable
fun FooterPresentation() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CabeceraFooter()
        CommonSpacer(size = 12)
        BottonesFooter()
        CommonSpacer(size = 12)
        TextoFooter()

    }
}

@Composable
fun TextoFooter() {
    Row {
        CommonText(
            modifier = Modifier,
            text = "o",
            fontWeight = FontWeight.Bold,
            fontSize = 15
        )
        CommonSpacer(size = 5)
        CommonText(
            modifier = Modifier,
            text = "Crear una cuenta",
            color = Color(0xFFAD0101),
            fontWeight = FontWeight.Bold,
            fontSize = 15
        )
    }
}

@Composable
fun BottonesFooter() {
    CommonOutlinedButtons(
        texto = "INGRESA COMO INVITADO"
    ) { }

    CommonSpacer(size = 5)
    CommonOutlinedButtons(
        texto = "INICIAR SESIÓN",
        containterColor = Color.Transparent,
        borderColor = Color(0xFFAD0101)
    ) { }
}

@Composable
fun CabeceraFooter() {
    CommonTextNameApp(
        modifier = Modifier
    )
    CommonSpacer(size = 12)
    CommonText(
        modifier = Modifier,
        text = "Tu inicio en un mundo de Anime!!",
        fontWeight = FontWeight.Bold,
        fontSize = 18
    )
}

@Composable
fun Fondo(modifier: Modifier) {
    CommonImage(
        modifier = modifier,
        imageSource = R.drawable.ic_fondo,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen Fondo",
    )
}
