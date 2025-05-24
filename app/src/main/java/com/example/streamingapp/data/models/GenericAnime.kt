package com.example.streamingapp.data.models

import com.google.gson.annotations.SerializedName

data class GenericAnime(
    val data: List<Anime>
)

data class Anime(
    @SerializedName("mal_id")
    val malId: Int,
    val title: String,
    val episodes: Int?,
    val score: Float?,
    val images: AnimeImages,
    val genres: List<GenresNew>,
    val synopsis: String,
)

data class GenresNew(
    val name: String
)

data class AnimeImages(
    val webp: AnimeImageUrl
)

data class AnimeImageUrl(
    @SerializedName("large_image_url")
    val imageUrl: String
)

