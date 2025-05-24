package com.example.streamingapp.data.network

import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.models.Genres
import com.example.streamingapp.data.models.UnicAnime
import com.example.streamingapp.data.models.UnicEpisodes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCliente {
    @GET("top/anime")
    suspend fun getTopAnimes(
        @Query("type") type: String? = null,
        @Query("filter") filter: String? = null,
        @Query("rating") rating: String? = null,
        @Query("sfw") sfw: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): Response<GenericAnime>

    @GET("top/manga")
    suspend fun getTopMangas(
        @Query("type") type: String? = null,
        @Query("filter") filter: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): Response<GenericAnime>

    @GET("watch/episodes")
    suspend fun getNewEpisodes(): Response<GenericEpisodes>

    @GET("genres/anime")
    suspend fun getGenres(): Response<Genres>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") animeId: Int): Response<UnicAnime>

    @GET("anime/{id}/videos")
    suspend fun getAnimeVideos(@Path("id") animeId: Int): Response<UnicEpisodes>
}