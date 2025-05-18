package com.example.streamingapp.data.repository

import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.network.services.AppServices
import javax.inject.Inject

class AppRepository @Inject constructor(private val llamadaApi: AppServices) {

    suspend fun getTopAnimes(filter: String): GenericAnime = llamadaApi.callGetTopAnimes(filter = filter)
    suspend fun getNewEpisodes(): GenericEpisodes = llamadaApi.callGetNewEpisodes()
    suspend fun getTopMangas(filter: String): GenericAnime = llamadaApi.callGetTopMangas(filter = filter)

}