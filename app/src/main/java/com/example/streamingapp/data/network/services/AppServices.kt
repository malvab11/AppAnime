package com.example.streamingapp.data.network.services

import android.util.Log
import com.example.streamingapp.data.models.Anime
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.models.Genres
import com.example.streamingapp.data.models.UnicAnime
import com.example.streamingapp.data.models.UnicEpisodes
import com.example.streamingapp.data.network.ApiCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppServices @Inject constructor(private val services: ApiCliente) {

    suspend fun callGetTopAnimes(filter: String, type: String?): GenericAnime {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getTopAnimes(filter = filter, type = type)
                if (response.isSuccessful) {
                    response.body() ?: GenericAnime(emptyList())
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    GenericAnime(emptyList())
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                GenericAnime(emptyList())
            }
        }
    }

    suspend fun callGetNewEpisodes(): GenericEpisodes {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getNewEpisodes()
                if (response.isSuccessful) {
                    response.body() ?: GenericEpisodes(emptyList())
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    GenericEpisodes(emptyList())
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                GenericEpisodes(emptyList())
            }

        }
    }

    suspend fun callGetTopMangas(filter: String): GenericAnime {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getTopMangas(filter = filter)
                if (response.isSuccessful) {
                    response.body() ?: GenericAnime(emptyList())
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    GenericAnime(emptyList())
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                GenericAnime(emptyList())
            }

        }
    }

    suspend fun callGetGenres(): Genres {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getGenres()
                if (response.isSuccessful) {
                    response.body() ?: Genres(emptyList())
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    Genres(emptyList())
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                Genres(emptyList())
            }

        }
    }

    suspend fun callGetAnimeById(animeId: Int): UnicAnime? {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getAnimeById(animeId = animeId)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                null
            }
        }
    }
    suspend fun callGetAnimeVideosById(animeId: Int): UnicEpisodes? {
        return withContext(Dispatchers.IO) {
            try {
                val response = services.getAnimeVideos(animeId = animeId)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("API_ERROR", "Código: ${response.code()}, Mensaje: ${response.message()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Excepción: ${e.localizedMessage}")
                null
            }
        }
    }
}