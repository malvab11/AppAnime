package com.example.streamingapp.ui.screens.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.streamingapp.R

@Composable
fun CommonTextNameApp(modifier: Modifier, color: Color = Color.White, fontSize: Int = 35) {
    Text(
        text = "Maraki Anime",
        color = color,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = fontSize.sp,
        modifier = modifier
    )
}

@Composable
fun CommonText(
    modifier: Modifier,
    text: String,
    color: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: Int,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CommonImage(
    modifier: Modifier,
    imageSource: Int,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        painter = painterResource(imageSource),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
fun CommonWebImages(model: String? = "", contentDescription: String? = "", contentScale: ContentScale = ContentScale.Crop, modifier: Modifier ){
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
fun CommonOutlinedButtons(
    modifier: Modifier = Modifier.fillMaxWidth(),
    texto: String,
    containterColor: Color = Color(0xFFAD0101),
    borderColor: Color = Color.Transparent,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        colors = ButtonDefaults.outlinedButtonColors(containerColor = containterColor),
        border = BorderStroke(width = 1.dp, color = borderColor)
    ) {
        CommonText(
            modifier = modifier,
            text = texto,
            fontWeight = FontWeight.Bold,
            fontSize = 12
        )
    }
}

@Composable
fun CommonCircularProgress(modifier: Modifier) {
    CircularProgressIndicator(
        color = Color.White,
        strokeWidth = 5.dp,
        modifier = modifier
    )
}

@Composable
fun CommonSpacer(modifier: Modifier = Modifier, size: Int) {
    Spacer(modifier.size(size.dp))
}

@Composable
fun Section(title: String, title2: String = "Ver Todos") {
    CommonSpacer(size = 10)
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),horizontalArrangement = Arrangement.SpaceBetween) {
        CommonText(modifier = Modifier, text = title, fontSize = 18, fontWeight = FontWeight.Bold)
        CommonText(modifier = Modifier, text = title2, fontSize = 15, fontWeight = FontWeight.Bold, color = Color.Red)
    }
    CommonSpacer(size = 10)
}

@Composable
fun HorizontalCardList(count: Int , spaced: Boolean = false) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (spaced) Arrangement.spacedBy(8.dp) else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(count) {
            Card(onClick = {}) {
                Column {
                    CommonImage(
                        modifier = Modifier,
                        imageSource = R.drawable.ic_header,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    CommonText(modifier = Modifier, text = "NameApp", fontSize = 12)
                }
            }
        }
    }
}

@Composable
fun LoginTextField(
    placeholder: String,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {}, // Puedes hacer esto dinámico con remember si lo necesitas
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
                        painter = painterResource(id = R.drawable.ic_visibility_off),
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
            focusedContainerColor = Color.White.copy(alpha = 0.9f),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        )
    )
}


