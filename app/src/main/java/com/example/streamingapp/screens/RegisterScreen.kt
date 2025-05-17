package com.example.streamingapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.streamingapp.R
import com.example.streamingapp.screens.commons.CommonImage
import com.example.streamingapp.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.screens.commons.CommonSpacer
import com.example.streamingapp.screens.commons.CommonText
import com.example.streamingapp.screens.commons.CommonTextNameApp

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        // Fondo con imagen
        CommonImage(
            modifier = Modifier.fillMaxSize(),
            imageSource = R.drawable.ic_fonto_login,
            contentScale = ContentScale.Crop,
            contentDescription = "Imagen Fondo",
        )

        // Capa con degradado (transparente -> gris -> transparente)
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
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.Black.copy(0.6f)),
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 30.dp, horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CommonImage(
                        imageSource = R.drawable.ic_loading,
                        contentDescription = "Logo Loading",
                        modifier = Modifier.size(150.dp)
                    )

                    CommonSpacer(size = 30)
                    CommonTextNameApp(modifier = Modifier.fillMaxWidth(), color = Color.White)
                    CommonSpacer(size = 30)

                    LoginTextField(placeholder = "Email")
                    CommonSpacer(size = 20)
                    LoginTextField(placeholder = "Usuario")
                    CommonSpacer(size = 20)
                    LoginTextField(
                        placeholder = "Contraseña",
                        isPassword = true
                    )

                    CommonSpacer(size = 12)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = false, onCheckedChange = {},colors = CheckboxDefaults.colors(uncheckedColor = Color.White))
                        CommonText(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Acepto los terminos y condiciones",
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

                    CommonOutlinedButtons(
                        texto = "CREAR CUENTA"
                    ) { }

                    Row {
                        CommonText(
                            modifier = Modifier,
                            text = "Ya tienes una cuenta?",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12
                        )
                        CommonSpacer(size = 5)
                        CommonText(
                            modifier = Modifier,
                            text = "Iniciar Sesion",
                            color = Color(0xFFAD0101),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun LoginTextField(
    placeholder: String,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        placeholder = {
            CommonText(
                modifier = Modifier,
                text = placeholder,
                color = Color.Black,
                fontSize = 12
            )
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { /* ocultar/mostrar contraseña */ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_visibility_off),
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White.copy(0.9f),
            focusedContainerColor = Color.White.copy(0.9f),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        )
    )
}