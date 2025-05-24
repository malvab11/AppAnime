package com.example.streamingapp.ui.screens.home.animeScreens.detailScreens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.streamingapp.ui.screens.commons.Section
import com.example.streamingapp.ui.screens.home.animeScreens.DetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailScreen(
    modifier: Modifier = Modifier,
    animeId: Int,
    animeDetailViewModel: DetailViewModel
) {

    LaunchedEffect(Unit) {
        animeDetailViewModel.getAnimeById(animeId)
    }
    val animeUnico by animeDetailViewModel.anime.observeAsState()
    val episodios by animeDetailViewModel.episodes.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black.copy(0.5f)))
        }
    ) { padding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())) {
            CommonWebImages(
                model = animeUnico?.data?.images?.webp?.imageUrl,
                contentDescription = animeUnico?.data?.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CommonText(
                    text = animeUnico?.data?.title ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CommonOutlinedButtons(
                    modifier = Modifier.weight(1f),
                    texto = "Play"
                ) { }

                CommonOutlinedButtons(
                    modifier = Modifier.weight(1f),
                    texto = "Download",
                    containterColor = Color.Transparent,
                    borderColor = Color(0xFFAD0101)
                ) { }
            }
            CommonText(
                text = animeUnico?.data?.synopsis ?: "",
                textAlign = TextAlign.Start,
                fontSize = 12,
                maxLines = 5
            )
            Section("Episodios")

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(episodios?.data?.episodes ?: emptyList()) {
                    CardView(
                        imagen = it.images.jpg.imageEpisodesUrl,
                        titulo = it.title,
                        episodios = it.episode,
                    )
                }
            }

        }

    }
}


@Composable
private fun CardView(imagen: String?, titulo: String?, episodios: String) {
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
            CommonText(text = episodios, fontSize = 12, textAlign = TextAlign.Start)
            CommonOutlinedButtons(texto = "Añadir") { }
        }
    }
}