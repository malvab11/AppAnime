package com.example.streamingapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.streamingapp.R
import com.example.streamingapp.ui.screens.commons.CommonImage
import com.example.streamingapp.ui.screens.commons.CommonSpacer
import com.example.streamingapp.ui.screens.commons.CommonText
import com.example.streamingapp.ui.screens.commons.CommonTextNameApp
import com.example.streamingapp.ui.screens.commons.Section

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAnimeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    CommonTextNameApp(modifier = Modifier, fontSize = 20)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black.copy(0.4f)),
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
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.Black)) {
            Column {
                CommonSpacer(size = 20)
                Section("Más buscados")
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(5) {
                        Card(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                CommonImage(
                                    modifier = Modifier.size(120.dp),
                                    imageSource = R.drawable.ic_header,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                                Column(modifier = Modifier.padding(10.dp)) {
                                    CommonText(modifier = Modifier, text = "NameApp", fontSize = 30, color = Color.Red)
                                    CommonText(modifier = Modifier, text = "Episodios", fontSize = 12, color = Color.Black)
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}