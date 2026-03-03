package com.example.crocusoft_todo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.crocusoft_todo.ui.navigation.AppNavigator


@Composable
fun App(
    innerPaddingValues: PaddingValues
) {

    val navController = rememberNavController()

    AppNavigator(
        innerPadding = innerPaddingValues,
        navController = navController
    )


}