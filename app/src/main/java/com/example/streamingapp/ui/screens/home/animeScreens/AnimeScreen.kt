package com.example.streamingapp.ui.screens.home.animeScreens

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.streamingapp.data.Screens
import com.example.streamingapp.data.models.Anime
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonWebImages
import com.example.streamingapp.ui.screens.commons.Section
import com.example.streamingapp.ui.screens.home.viewModels.AnimesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimesScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    animesViewModel: AnimesViewModel,
    pantallaIndex: Int,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        animesViewModel.loadDataForScreen(pantallaIndex)
    }
    val animes by animesViewModel.animes.observeAsState()
    val episodios by animesViewModel.episodios.observeAsState()
    val mangas by animesViewModel.mangas.observeAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0XFF191A1F))
            .padding(bottom = padding.calculateBottomPadding())
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Body(
                animes = animes,
                mangas = mangas,
                episodios = episodios,
                navController = navController
            )
        }
    }
}


@Composable
private fun Body(
    animes: GenericAnime?,
    episodios: GenericEpisodes?,
    mangas: GenericAnime?,
    navController: NavHostController
) {
    val context = LocalContext.current
    CommonWebImages(
        model = animes?.data?.get(0)?.images?.webp?.imageUrl,
        contentDescription = animes?.data?.get(0)?.title,
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp * 0.5f)
    )

    Section("Top Animes")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = animes?.data?.take(5) ?: emptyList()) { anime ->
            CardView(
                imagen = anime.images.webp.imageUrl,
                titulo = anime.title,
                animeId = anime
            ) {
                navController.navigate(Screens.AnimeDetailScreen.createRuta(animeId = it))
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    Section("Nuevos Episodios")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = episodios?.data?.take(5) ?: emptyList()) { episodio ->
            CardView(
                imagen = episodio.entry.images.webp.imageUrl,
                titulo = episodio.entry.title,
                animeId = null
            ) {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    Section("Top Mangas")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = mangas?.data?.take(5) ?: emptyList()) { mangas ->
            CardView(imagen = mangas.images.webp.imageUrl, titulo = mangas.title, animeId = null) {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
private fun CardView(
    imagen: String?,
    titulo: String?,
    animeId: Anime?,
    onItemSelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(250.dp)
            .clickable {
                onItemSelected(animeId!!.malId)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonWebImages(
            model = imagen,
            contentDescription = titulo,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .weight(1f)
        )
        CommonText(
            modifier = Modifier,
            text = titulo ?: "",
            fontSize = 12,
            fontWeight = FontWeight.Bold

        )
    }
}
