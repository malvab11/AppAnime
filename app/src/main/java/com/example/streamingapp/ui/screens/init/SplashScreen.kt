package com.example.streamingapp.ui.screens.init

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.streamingapp.R
import com.example.streamingapp.data.Screens
import com.example.streamingapp.ui.screens.commons.CommonCircularProgress
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonTextNameApp
import com.example.streamingapp.ui.screens.init.viewModels.SplashScreenViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    splashScreenViewModel: SplashScreenViewModel
) {

    val internet by splashScreenViewModel.internet.observeAsState(false)
    val mensaje by splashScreenViewModel.mensaje.observeAsState()
    val context = LocalContext.current
    val activity = context as? Activity

    LaunchedEffect(internet) {
        if (internet) {
            kotlinx.coroutines.delay(1000)
            Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
            kotlinx.coroutines.delay(4000)
            navController.navigate(Screens.PresentationScreen.ruta) {
                popUpTo(Screens.SplashScreen.ruta) {
                    inclusive = true
                }
            }
        } else {
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
            kotlinx.coroutines.delay(3000)
            activity?.finishAffinity()
        }
    }

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
