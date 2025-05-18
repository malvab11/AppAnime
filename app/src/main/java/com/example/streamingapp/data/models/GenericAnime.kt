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
    val images: AnimeImages
)

data class AnimeImages(
    val webp: AnimeImageUrl
)

data class AnimeImageUrl(
    @SerializedName("large_image_url")
    val imageUrl: String
)

