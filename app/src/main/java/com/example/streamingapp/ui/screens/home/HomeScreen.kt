package com.example.streamingapp.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.streamingapp.R
import com.example.streamingapp.data.models.EpisodeAnime
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonWebImages
import com.example.streamingapp.ui.screens.commons.Section
import com.example.streamingapp.ui.screens.home.viewModels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel) {

    val animes by homeViewModel.animes.observeAsState()
    val episodios by homeViewModel.episodios.observeAsState()
    val mangas by homeViewModel.mangas.observeAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {

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
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black.copy(alpha = 0.4f),
                contentColor = Color.White
            ) {
                val items = listOf(
                    Icons.Default.Home to "Home",
                    Icons.Default.List to "Navegar",
                    Icons.Default.Favorite to "Favorites",
                    Icons.Default.Person to "Profile"
                )

                items.forEach { (icon, label) ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = label,
                                tint = Color.White
                            )
                        },
                        label = {
                            CommonText(modifier = Modifier, text = label, fontSize = 12)
                        }
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF191A1F))
                .padding(bottom = padding.calculateBottomPadding())
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Body(animes = animes, mangas = mangas, episodios = episodios)
            }
        }
    }
}

@Composable
private fun Body(animes: GenericAnime?, episodios: GenericEpisodes?, mangas: GenericAnime?) {
    CommonWebImages(
        model = animes?.data?.get(0)?.images?.webp?.imageUrl,
        contentDescription = animes?.data?.get(0)?.title,
        contentScale = ContentScale.FillWidth,
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
            CardView(imagen = anime.images.webp.imageUrl, titulo = anime.title)
        }
    }

    Section("Nuevos Episodios")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = episodios?.data?.take(5) ?: emptyList()) { episodio ->
            CardView(imagen = episodio.entry.images.webp.imageUrl, titulo = episodio.entry.title)
        }
    }

    Section("Top Mangas")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = mangas?.data?.take(5) ?: emptyList()) { mangas ->
            CardView(imagen = mangas.images.webp.imageUrl, titulo = mangas.title)
        }
    }
}

@Composable
private fun CardView(modifier: Modifier = Modifier, imagen: String?, titulo: String?) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(250.dp),
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
