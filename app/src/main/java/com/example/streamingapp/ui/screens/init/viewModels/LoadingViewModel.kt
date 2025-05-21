package com.example.streamingapp.ui.screens.init.viewModels

import android.app.Application
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application = application) {

    private val _internet = MutableLiveData<Boolean>()
    val internet: LiveData<Boolean> = _internet
    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje

    init {
        internetValidation()
    }

    private fun internetValidation(){
        val isConnected = isInternetAvailable()
        _internet.value = isConnected
        if (!isConnected){
            _mensaje.value = "Error de conexión a Internet"
        }else{
            _mensaje.value = "Bienvenido!!!"
        }
    }

    private fun isInternetAvailable() : Boolean {
        val conexion = getApplication<Application>().getSystemService(ConnectivityManager::class.java)

        val conexionInternet = conexion.activeNetwork ?: return false
        val senalInternet = conexion.getNetworkCapabilities(conexionInternet) ?: return false

        return senalInternet.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                senalInternet.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)

    }
}