package com.example.streamingapp.ui.screens.home.animeScreens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streamingapp.data.models.Anime
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.UnicAnime
import com.example.streamingapp.data.models.UnicEpisodes
import com.example.streamingapp.domain.useCases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCases: AppUseCases) : ViewModel() {
    private val _anime = MutableLiveData<UnicAnime?>()
    val anime: LiveData<UnicAnime?> = _anime
    private val _episodes = MutableLiveData<UnicEpisodes?>()
    val episodes: LiveData<UnicEpisodes?> = _episodes

    fun getAnimeById(animeId: Int) {
        viewModelScope.launch {
            val responseAnime = useCases.getAnimeById(animeId)
            val responseAnimeEpisodes = useCases.getAnimeVideosById(animeId)
            Log.i("AnimeDetail", "Recibido: $responseAnime")
            Log.i("AnimeDetailVideos", "Recibido: $responseAnimeEpisodes")
            _anime.postValue(responseAnime)
            _episodes.postValue(responseAnimeEpisodes)
        }
    }
}