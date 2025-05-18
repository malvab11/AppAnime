package com.example.streamingapp.ui.screens.home.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streamingapp.data.models.GenericAnime
import com.example.streamingapp.data.models.GenericEpisodes
import com.example.streamingapp.domain.useCases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val useCases: AppUseCases) : ViewModel() {

    private val _animes = MutableLiveData<GenericAnime>()
    val animes: LiveData<GenericAnime> = _animes
    private val _mangas = MutableLiveData<GenericAnime>()
    val mangas: LiveData<GenericAnime> = _mangas
    private val _episodios = MutableLiveData<GenericEpisodes>()
    val episodios: LiveData<GenericEpisodes> = _episodios


    init {
        callAnimes()
    }


    fun callAnimes(){
        viewModelScope.launch {
            val responseAnimes = useCases.getTopAnimes(filter = "bypopularity")
            val responseEpisodios = useCases.getNewEpisodes()
            val responseMangas = useCases.getTopMangas(filter = "bypopularity")
            if(responseAnimes.data.isNotEmpty() && responseMangas.data.isNotEmpty() && responseEpisodios.data.isNotEmpty()){
                _animes.value = responseAnimes
                _mangas.value = responseMangas
                _episodios.value = responseEpisodios
                Log.i("Animes",_animes.value.toString())
                Log.i("Mangas",_mangas.value.toString())
                Log.i("Capitulos",_episodios.value.toString())
            }else{
                Log.i("Animes","error")
            }
        }
    }

}