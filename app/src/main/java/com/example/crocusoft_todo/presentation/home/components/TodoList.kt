package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.HomeContract

@Composable
fun TodoList(
    todos: List<TodoEntity>,
    postIntent: (HomeContract.Intent) -> Unit
) {


    Row(
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
            todos.forEach { todo ->
                TodoItem(
                    todoEntity = todo,
                    postIntent = postIntent
                )
            }
        }
    }


}