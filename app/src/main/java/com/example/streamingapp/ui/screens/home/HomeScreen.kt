package com.example.streamingapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.streamingapp.R
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, animesViewModel: AnimesViewModel) {

    var pantalla by rememberSaveable { mutableStateOf(0) }

    val titulos = listOf("", "Buscar", "Favoritos", "Perfil")

    Scaffold(
        modifier = modifier,
        topBar = { MyTopAppBar(titulos = titulos[pantalla]) },
        bottomBar = { MyBottomBar(selectedScreen = pantalla) { pantalla = it } }
    ) { padding ->

        when (pantalla) {
            0 -> AnimesScreen(pantallaIndex = 0, padding = padding, animesViewModel = animesViewModel)
            1 -> NavigatorScreen(pantallaIndex = 1,padding = padding, animesViewModel = animesViewModel)
            2 -> FavoriteScreen()
            3 -> ProfileScreen()
        }
    }

}

@Composable
fun MyBottomBar(selectedScreen: Int, onClick: (Int) -> Unit) {

    //Declaracion de pantallas
    val screens = listOf(
        Icons.Default.Home to "Inicio",
        Icons.Default.List to "Navegar",
        Icons.Default.Favorite to "Favoritos",
        Icons.Default.Person to "Perfil"
    )

    NavigationBar(
        containerColor = Color.Black.copy(alpha = 0.4f),
        contentColor = Color.White
    ) {
        screens.forEachIndexed { intPantalla, (icono, titulo) ->
            NavigationBarItem(
                selected = selectedScreen == intPantalla,
                onClick = { onClick(intPantalla) },
                icon = {
                    Icon(
                        imageVector = icono,
                        contentDescription = titulo,
                        tint = Color.White
                    )
                },
                label = {
                    CommonText(modifier = Modifier, text = titulo, fontSize = 12)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(titulos: String) {
    TopAppBar(
        title = {
            CommonText(modifier = Modifier, text = titulos, fontSize = 12)
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black.copy(0.3f)),
        navigationIcon = {
            CommonImage(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(40.dp),
                imageSource = R.drawable.ic_loading,
                contentDescription = "",
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}
