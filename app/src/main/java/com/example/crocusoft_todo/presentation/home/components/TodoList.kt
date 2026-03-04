package com.example.crocusoft_todo.presentation.home.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.crocusoft_todo.core.AppTabIndex
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.HomeContract

@Composable
fun TodoList(
    todos: List<TodoEntity>,
    tabIndex: AppTabIndex,
    postIntent: (HomeContract.Intent) -> Unit
) {


    LaunchedEffect(Unit) {
        when (tabIndex) {
            AppTabIndex.ALL -> {
                postIntent(HomeContract.Intent.OnFetchTodos)
            }

            AppTabIndex.ACTIVE -> postIntent(HomeContract.Intent.OnFetchActiveTodos)
            AppTabIndex.COMPLETED -> postIntent(HomeContract.Intent.OnFetchCompletedTodos)
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (todos.isEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()

            ) {
                Text(
                    text = stringResource(Strings.no_task),
                    style = DsTheme.textStyle.t17SemiBold
                )
            }

        } else {
            LazyColumn {
                items(
                    count = todos.size,
                ) {
                    TodoItem(
                        modifier = Modifier.animateItem(
                            fadeInSpec = tween(durationMillis = 250),
                            fadeOutSpec = tween(durationMillis = 100),
                            placementSpec = spring(stiffness = Spring.StiffnessLow)
                        ),
                        todoEntity = todos[it],
                        postIntent = postIntent
                    )

                    Spacer(modifier = Modifier.height(DsTheme.dimens.dp2))

                }

            }

        }
    }


}