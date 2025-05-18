package com.example.streamingapp.data.network

import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import retrofit2.Response
import retrofit2.http.GET
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
}