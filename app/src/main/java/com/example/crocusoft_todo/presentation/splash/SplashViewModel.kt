package com.example.crocusoft_todo.presentation.splash

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


const val SHARED_PREF_KEY = "isLogged"

@HiltViewModel
class SplashViewModel @Inject constructor(val sharedPreference: SharedPreferences) : ViewModel() {


    private val _effect = MutableSharedFlow<SplashContract.Effect>()

    val effect = _effect.asSharedFlow()

    fun onIntent(intent: SplashContract.Intent) {
        when (intent) {

            SplashContract.Intent.HandleLog -> {

                sharedPreference.edit(commit = true) {
                    putBoolean(SHARED_PREF_KEY, true)
                    viewModelScope.launch {
                        _effect.emit(SplashContract.Effect.Navigate)
                    }


                }
            }

            SplashContract.Intent.CheckLog -> {
                val isLogged = sharedPreference.getBoolean(SHARED_PREF_KEY, false)
                Log.i("isLogged",isLogged.toString())

                if (isLogged) {
                    viewModelScope.launch {
                        _effect.emit(SplashContract.Effect.Navigate)
                    }
                }

            }
        }
    }
}
