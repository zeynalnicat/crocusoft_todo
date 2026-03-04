package com.example.crocusoft_todo.presentation.home.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
            Log.i("todos", todos.toString())
            todos.forEach { todo ->
                TodoItem(
                    todoEntity = todo,
                    postIntent = postIntent
                )

                Spacer(modifier = Modifier.height(DsTheme.dimens.dp2))
            }
        }
    }


}