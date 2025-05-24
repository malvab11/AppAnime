package com.example.streamingapp.ui.screens.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.streamingapp.ui.screens.commons.CommonOutlinedButtons
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonWebImages
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel

@Composable
fun NavigatorScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    animesViewModel: AnimesViewModel,
    pantallaIndex: Int
) {
    LaunchedEffect(Unit) {
        animesViewModel.loadDataForScreen(pantallaIndex)
    }

    var selector by rememberSaveable { mutableStateOf(0) }

    val animes by animesViewModel.animes.observeAsState()
    val mangas by animesViewModel.mangas.observeAsState()
    val peliculas by animesViewModel.movies.observeAsState()

    Column(
        modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        HeaderSelector(selector) { selector = it }

        Crossfade(targetState = selector, label = "content-transition") { selected ->
            val lista = when (selected) {
                0 -> animes?.data ?: emptyList()
                1 -> mangas?.data ?: emptyList()
                else -> peliculas?.data ?: emptyList()
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items = lista) {
                    CardView(
                        imagen = it.images.webp.imageUrl,
                        titulo = it.title,
                        episodios = it.episodes,
                        score = it.score,
                        genres = it.genres.joinToString(", ") { genre -> genre.name }
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderSelector(current: Int, onSelect: (Int) -> Unit) {
    val tabs = listOf("Animes", "Mangas", "Películas")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, title ->
            CommonText(
                modifier = Modifier.clickable { onSelect(index) },
                text = title,
                fontSize = if (current == index) 16 else 14,
                color = if (current == index) Color(0xFFAD0101) else Color.White,
                fontWeight = if (current == index) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

@Composable
private fun CardView(imagen: String?, titulo: String?, episodios: Int?, score: Float?, genres: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.BottomCenter
        ) {
            CommonWebImages(
                model = imagen,
                contentDescription = titulo,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CommonText(
                text = titulo.orEmpty(),
                fontSize = 20,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                maxLines = 2
            )
            CommonText(text = "Episodios: $episodios", fontSize = 12, textAlign = TextAlign.Start)
            CommonText(text = "Score: $score", fontSize = 12, textAlign = TextAlign.Start)
            CommonText(
                text = "Géneros: $genres",
                fontSize = 12,
                textAlign = TextAlign.Start,
                maxLines = 3
            )
            CommonOutlinedButtons(texto = "Añadir") { }
        }
    }
}
