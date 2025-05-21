package com.example.streamingapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

    val animes by animesViewModel.animes.observeAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = animes?.data ?: emptyList()){
            CardView(imagen = it.images.webp.imageUrl, titulo = it.title)
        }
    }
}

@Composable
private fun CardView(imagen: String?, titulo: String?) {
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