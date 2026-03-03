package com.example.crocusoft_todo.ui.navigation

sealed class AppRoutes(val route: String) {

    data object SplashScreen : AppRoutes("splash")

    data object HomeScreen: AppRoutes("home")
}