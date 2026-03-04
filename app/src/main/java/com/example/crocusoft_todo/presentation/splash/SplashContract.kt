package com.example.crocusoft_todo.presentation.splash

sealed interface SplashContract {

    sealed interface Intent {

        data object HandleLog : Intent
        
    }

    sealed interface Effect {


        data object Navigate : Effect
    }



}