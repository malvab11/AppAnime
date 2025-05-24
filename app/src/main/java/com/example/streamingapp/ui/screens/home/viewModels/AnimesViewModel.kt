package com.example.streamingapp.ui.screens.home.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.data.models.Genres
import com.example.streamingapp.domain.useCases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimesViewModel @Inject constructor(private val useCases: AppUseCases) : ViewModel() {

    private val _animes = MutableLiveData<GenericAnime>()
    val animes: LiveData<GenericAnime> = _animes
    private val _mangas = MutableLiveData<GenericAnime>()
    val mangas: LiveData<GenericAnime> = _mangas
    private val _episodios = MutableLiveData<GenericEpisodes>()
    val episodios: LiveData<GenericEpisodes> = _episodios
    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres
    private val _movies = MutableLiveData<GenericAnime>()
    val movies: LiveData<GenericAnime> = _movies

    fun loadDataForScreen(screenId: Int) {
        viewModelScope.launch {
            when(screenId) {
                0 -> {
                    callAnimes()
                    callMangas()
                    callEpisodes()
                }
                1 -> {
                    callMovies()
                    callGenres()
                }
            }
        }
    }

    fun callAnimes() {
        viewModelScope.launch {
            val responseAnimes = useCases.getTopAnimes(filter = "bypopularity", type = "tv")
            if (responseAnimes.data.isNotEmpty()) {
                _animes.value = responseAnimes
            } else {
                Log.i("Animes", "error")
            }
        }
    }

    fun callEpisodes() {
        viewModelScope.launch {
            val responseEpisodios = useCases.getNewEpisodes()
            if (responseEpisodios.data.isNotEmpty()) {
                _episodios.value = responseEpisodios
            } else {
                Log.i("Capitulos", "error")
            }
        }
    }

    fun callGenres() {
        viewModelScope.launch {
            val responseGenres = useCases.getGenres()
            if (responseGenres.data.isNotEmpty()) {
                _genres.value = responseGenres
            } else {
                Log.i("Genres", "error")
            }
        }
    }

    fun callMovies() {
        viewModelScope.launch {
            val responseMovies = useCases.getTopAnimes(filter = "bypopularity", type = "movie")
            if (responseMovies.data.isNotEmpty()) {
                _movies.value = responseMovies
            } else {
                Log.i("Movies", "error")
            }
        }
    }

    fun callMangas() {
        viewModelScope.launch {
            val responseMangas = useCases.getTopMangas(filter = "bypopularity")
            if (responseMangas.data.isNotEmpty()) {
                _mangas.value = responseMangas
            } else {
                Log.i("Mangas", "error")
            }
        }
    }

}