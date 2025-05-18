package com.example.streamingapp.data.network.services

import android.util.Log
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.network.ApiCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppServices @Inject constructor(private val services: ApiCliente) {

    suspend fun callGetTopAnimes(filter: String): GenericAnime {
        return withContext(Dispatchers.IO) {
            val response = services.getTopAnimes(filter = filter)
            if (response.isSuccessful) {
                response.body() ?: GenericAnime(emptyList())
            } else {
                Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                GenericAnime(emptyList())
            }
        }
    }
    suspend fun callGetNewEpisodes(): GenericEpisodes {
        return withContext(Dispatchers.IO) {
            val response = services.getNewEpisodes()
            if (response.isSuccessful) {
                response.body() ?: GenericEpisodes(emptyList())
            } else {
                Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                GenericEpisodes(emptyList())
            }
        }
    }
    suspend fun callGetTopMangas(filter: String): GenericAnime {
        return withContext(Dispatchers.IO) {
            val response = services.getTopMangas(filter = filter)
            if (response.isSuccessful) {
                response.body() ?: GenericAnime(emptyList())
            } else {
                Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                GenericAnime(emptyList())
            }
        }
    }
}