package com.example.streamingapp.ui.screens.init

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.example.streamingapp.R
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.ui.screens.commons.CommonSpacer
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonTextNameApp
import com.example.streamingapp.ui.screens.commons.LoginTextField

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        // Fondo con imagen
        CommonImage(
            modifier = Modifier.fillMaxSize(),
            imageSource = R.drawable.ic_fonto_login,
            contentDescription = "Imagen Fondo",
            contentScale = ContentScale.Crop
        )

        // Degradado y contenido
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
            RegisterCardContent()
        }
    }
}

@Composable
private fun RegisterCardContent() {
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
            CommonTextNameApp(modifier = Modifier.fillMaxWidth(), color = Color.White)
            CommonSpacer(size = 30)

            LoginTextField("Email")
            CommonSpacer(size = 20)
            LoginTextField("Usuario")
            CommonSpacer(size = 20)
            LoginTextField("Contraseña", isPassword = true)

            CommonSpacer(size = 12)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(uncheckedColor = Color.White)
                )
                CommonText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Acepto los términos y condiciones",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 12
                )
            }

            CommonSpacer(size = 12)

            CommonText(
                modifier = Modifier,
                text = "MARAKI ANIME ofrece los animes más vanguardistas y la interfaz más amigable para el usuario.",
                fontWeight = FontWeight.Bold,
                fontSize = 12
            )

            CommonSpacer(size = 12)

            CommonOutlinedButtons(texto = "CREAR CUENTA") {
                // Acción al crear cuenta
            }

            CommonSpacer(size = 12)

            Row {
                CommonText(
                    modifier = Modifier,
                    text = "¿Ya tienes una cuenta?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12
                )
                CommonSpacer(size = 5)
                CommonText(
                    modifier = Modifier,
                    text = "Iniciar Sesión",
                    color = Color(0xFFAD0101),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15
                )
            }
        }
    }
}
