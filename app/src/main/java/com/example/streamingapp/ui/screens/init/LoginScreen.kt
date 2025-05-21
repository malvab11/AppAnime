package com.example.streamingapp.ui.screens.init

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.streamingapp.R
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.ui.screens.commons.CommonSpacer
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonTextNameApp
import com.example.streamingapp.ui.screens.commons.LoginTextField

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier = modifier.fillMaxSize()) {

        // Fondo con imagen
        CommonImage(
            modifier = Modifier.fillMaxSize(),
            imageSource = R.drawable.ic_fonto_login,
            contentDescription = "Imagen Fondo",
            contentScale = ContentScale.Crop
        )

        // Degradado y contenido centrado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Gray.copy(alpha = 0.5f),
                            Color.Transparent
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            LoginCardContent()
        }
    }
}

@Composable
private fun LoginCardContent() {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Black.copy(0.6f))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonImage(
                imageSource = R.drawable.ic_loading,
                contentDescription = "Logo Loading",
                modifier = Modifier.size(150.dp)
            )

            CommonSpacer(size = 30)
            CommonTextNameApp(modifier = Modifier.fillMaxWidth())
            CommonSpacer(size = 30)

            LoginTextField("Email o Usuario")
            CommonSpacer(size = 20)
            LoginTextField("Contraseña", isPassword = true)

            CommonSpacer(size = 12)

            CommonText(
                modifier = Modifier.fillMaxWidth(),
                text = "Olvidaste Contraseña?",
                color = Color(0xFFAD0101),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                fontSize = 12
            )

            CommonSpacer(size = 12)

            CommonText(
                modifier = Modifier,
                text = "Estas a un click de iniciar tu aventura!!!",
                fontWeight = FontWeight.Bold,
                fontSize = 12
            )

            CommonSpacer(size = 12)

            CommonOutlinedButtons(texto = "INICIAR SESION") {
                // Acción al iniciar sesión
            }

            CommonSpacer(size = 12)

            CommonText(
                modifier = Modifier,
                text = "Crear una cuenta",
                fontWeight = FontWeight.Bold,
                fontSize = 12
            )
        }
    }
}
