package com.example.streamingapp.screens.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonTextNameApp(modifier: Modifier, color: Color = Color.White) {
    Text(
        text = "Maraki Anime",
        color = color,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
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
        textAlign = textAlign
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

