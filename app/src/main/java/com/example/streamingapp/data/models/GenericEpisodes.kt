package com.example.streamingapp.data.models

import com.google.gson.annotations.SerializedName

data class GenericEpisodes(
    val data: List<EpisodeGroup>
)

data class EpisodeGroup(
    val entry: EpisodeAnime, // nueva clase aquí
    val episodes: List<Episode>,
    val region_locked: Boolean
)

data class EpisodeAnime(
    @SerializedName("mal_id")
    val malId: Int,
    val title: String,
    val images: AnimeImages
)

data class Episode(
    @SerializedName("mal_id")
    val malId: Int,
    val url: String,
    val title: String,
    val premium: Boolean
)


