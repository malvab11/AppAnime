package com.example.streamingapp.domain.useCases

import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.repository.AppRepository
import javax.inject.Inject

class AppUseCases @Inject constructor(private val useServices : AppRepository) {

    suspend fun getTopAnimes(filter : String, type: String?) = useServices.getTopAnimes(filter = filter, type = type)
    suspend fun getNewEpisodes() = useServices.getNewEpisodes()
    suspend fun getTopMangas(filter: String) = useServices.getTopMangas(filter = filter)
    suspend fun getGenres() = useServices.getGenres()
    suspend fun getAnimeById(animeId: Int) = useServices.getAnimeById(animeId = animeId)
    suspend fun getAnimeVideosById(animeId: Int) = useServices.getAnimeVideosById(animeId = animeId)

}