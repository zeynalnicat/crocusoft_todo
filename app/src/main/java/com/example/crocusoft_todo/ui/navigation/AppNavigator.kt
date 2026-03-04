package com.example.crocusoft_todo.ui.navigation

import android.content.SharedPreferences
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crocusoft_todo.presentation.home.HomeView
import com.example.crocusoft_todo.presentation.splash.SHARED_PREF_KEY
import com.example.crocusoft_todo.presentation.splash.SplashView


@Composable
fun AppNavigator(
    innerPadding: PaddingValues,
    navController: NavHostController,
    sharedPreferences: SharedPreferences
) {

    val isLoggedIn = sharedPreferences.getBoolean(SHARED_PREF_KEY, false)

    NavHost(
        modifier = Modifier.padding(paddingValues = innerPadding),
        startDestination = if (!isLoggedIn) AppRoutes.SplashScreen.route else AppRoutes.HomeScreen.route,
        navController = navController
    ) {
        composable(AppRoutes.SplashScreen.route) { SplashView(navController) }
        composable(AppRoutes.HomeScreen.route) { HomeView() }
    }

}