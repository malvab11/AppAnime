package com.example.streamingapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.streamingapp.R
import com.example.streamingapp.screens.commons.CommonCircularProgress
import com.example.streamingapp.screens.commons.CommonImage
import com.example.streamingapp.screens.commons.CommonText
import com.example.streamingapp.screens.commons.CommonTextNameApp

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (image, nameApp, circularProgress, powered) = createRefs()
        CommonImage(
            imageSource = R.drawable.ic_loading,
            contentDescription = "Logo Loading",
            modifier = Modifier
                .size(140.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

        )
        CommonTextNameApp(
            modifier = Modifier.constrainAs(nameApp) {
                top.linkTo(image.bottom)
                bottom.linkTo(circularProgress.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        CommonCircularProgress(
            modifier = Modifier.constrainAs(circularProgress) {
                top.linkTo(image.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        CommonText(
            text = "Powered by ......",
            fontWeight = FontWeight.Bold,
            fontSize = 15,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .constrainAs(powered) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }

}
