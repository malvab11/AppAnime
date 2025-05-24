package com.example.streamingapp.data.repository

import com.example.streamingapp.data.models.Anime
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.models.Genres
import com.example.streamingapp.data.models.UnicAnime
import com.example.streamingapp.data.models.UnicEpisodes
import com.example.streamingapp.data.network.services.AppServices
import javax.inject.Inject

class AppRepository @Inject constructor(private val llamadaApi: AppServices) {

    suspend fun getTopAnimes(filter: String, type: String?): GenericAnime = llamadaApi.callGetTopAnimes(filter = filter, type = type)
    suspend fun getNewEpisodes(): GenericEpisodes = llamadaApi.callGetNewEpisodes()
    suspend fun getTopMangas(filter: String): GenericAnime = llamadaApi.callGetTopMangas(filter = filter)
    suspend fun getGenres(): Genres = llamadaApi.callGetGenres()
    suspend fun getAnimeById(animeId: Int): UnicAnime? = llamadaApi.callGetAnimeById(animeId = animeId)
    suspend fun getAnimeVideosById(animeId: Int): UnicEpisodes? = llamadaApi.callGetAnimeVideosById(animeId = animeId)

}