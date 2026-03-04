package com.example.crocusoft_todo.presentation.splash

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.crocusoft_todo.ui.navigation.AppRoutes


@Composable
fun SplashView(navController: NavController, viewModel: SplashViewModel = hiltViewModel()) {

    SplashContent(
        navController = navController,
        effect = viewModel.effect,
        postIntent = viewModel::onIntent,
    )
}