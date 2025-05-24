package com.example.streamingapp.data.models

import com.google.gson.annotations.SerializedName

data class UnicAnime(
    val data: Anime
)

data class UnicEpisodes(
    val data : EpisodesUniques
)

data class EpisodesUniques(
    val episodes: List<EpisodesArray>
)

data class EpisodesArray(
    @SerializedName("mal_id") val malid: Int,
    val title: String,
    val episode: String,
    val images: EpisodesImages
)

data class EpisodesImages(
    val jpg: EpisodesImagesUrl
)

data class EpisodesImagesUrl(
    @SerializedName("image_url") val imageEpisodesUrl: String
)
