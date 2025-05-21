package com.example.streamingapp.ui.screens.init

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import com.example.streamingapp.R
import com.example.streamingapp.data.Screens
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.ui.screens.commons.CommonSpacer
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonTextNameApp

@Composable
fun PresentationScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Fondo(modifier = Modifier.fillMaxSize())
        FondoDegradado()
        FooterPresentation(navController)
    }
}

@Composable
private fun FondoDegradado() {
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
private fun FooterPresentation(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CabeceraFooter()
        CommonSpacer(size = 12)
        BottonesFooter(navController)
        CommonSpacer(size = 12)
        TextoFooter(navController)

    }
}

@Composable
private fun TextoFooter(navController: NavHostController) {
    Row {
        CommonText(
            modifier = Modifier,
            text = "o",
            fontWeight = FontWeight.Bold,
            fontSize = 15
        )
        CommonSpacer(size = 5)
        CommonText(
            modifier = Modifier.clickable { navController.navigate(Screens.RegisterScreen.ruta) },
            text = "Crear una cuenta",
            color = Color(0xFFAD0101),
            fontWeight = FontWeight.Bold,
            fontSize = 15
        )
    }
}

@Composable
private fun BottonesFooter(navController: NavHostController) {
    CommonOutlinedButtons(
        texto = "INGRESA COMO INVITADO"
    ) { navController.navigate(Screens.HomeScreen.ruta) }

    CommonSpacer(size = 5)
    CommonOutlinedButtons(
        texto = "INICIAR SESIÓN",
        containterColor = Color.Transparent,
        borderColor = Color(0xFFAD0101)
    ) { navController.navigate(Screens.LoginScreen.ruta) }
}

@Composable
private fun CabeceraFooter() {
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
private fun Fondo(modifier: Modifier) {
    CommonImage(
        modifier = modifier,
        imageSource = R.drawable.ic_fondo,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen Fondo",
    )
}
