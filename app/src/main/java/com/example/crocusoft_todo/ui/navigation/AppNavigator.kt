package com.example.crocusoft_todo.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crocusoft_todo.presentation.home.HomeView
import com.example.crocusoft_todo.presentation.splash.SplashView


@Composable
fun AppNavigator(
    innerPadding: PaddingValues,
    navController: NavHostController
) {

    NavHost(
        modifier = Modifier.padding(paddingValues = innerPadding),
        startDestination = AppRoutes.SplashScreen.route,
        navController = navController
    ) {
        composable(AppRoutes.SplashScreen.route) { SplashView(navController) }
        composable(AppRoutes.HomeScreen.route) { HomeView() }
    }

}