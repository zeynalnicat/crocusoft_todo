package com.example.crocusoft_todo.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.components.AppTabView
import com.example.crocusoft_todo.presentation.home.components.HomeSearchContainer

import kotlinx.coroutines.flow.SharedFlow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeContent(
    state: HomeContract.State,
    effect: SharedFlow<HomeContract.Effect>,
    postIntent: (HomeContract.Intent) -> Unit,
) {

    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(effect) {
        effect.collect {
            when (it) {
                is HomeContract.Effect.OnShowError -> snackBarHostState.showSnackbar(message = it.message)
                is HomeContract.Effect.OnShowSuccess -> {
//                    snackBarHostState.showSnackbar(
//                        message = it.message,
//                        duration = SnackbarDuration.Short,
//
//                    )

                }
            }
        }
    }


    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(DsTheme.dimens.dp4)
        ) {

            Column(
                modifier = Modifier.padding(PaddingValues(bottom = DsTheme.dimens.dp14))
            ) {


                Text(
                    text = stringResource(Strings.home_today),
                    style = DsTheme.textStyle.t36SemiBold
                )


                Spacer(modifier = Modifier.height(DsTheme.dimens.dp8))



                AppTabView(
                    tabs = listOf(
                        stringResource(Strings.all),
                        stringResource(Strings.active),
                        stringResource(
                            Strings.completed
                        )
                    ),
                    state = state,
                    postIntent = postIntent
                )
            }



            HomeSearchContainer(
                modifier = Modifier.align(
                    Alignment.BottomStart
                ),
                searchQuery = state.query,
                postIntent = postIntent,
                isEditAction = state.isEditIntent
                )
        }
    }


}