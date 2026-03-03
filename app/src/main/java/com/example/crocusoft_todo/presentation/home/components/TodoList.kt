package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.runtime.Composable
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.HomeContract

@Composable
fun TodoList(
    todos: List<TodoEntity>,
    postIntent: (HomeContract.Intent) -> Unit
) {
    todos.forEach { todo ->
        TodoItem(
            todoEntity = todo,
            postIntent = postIntent
        )
    }

}