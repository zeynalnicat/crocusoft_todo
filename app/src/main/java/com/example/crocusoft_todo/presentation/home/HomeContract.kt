package com.example.crocusoft_todo.presentation.home

import com.example.crocusoft_todo.domain.entity.TodoEntity

sealed interface HomeContract {

    sealed interface Intent {
        data class OnSetQuery(val query: String) : Intent

        data class OnEditTodo(val todoEntity: TodoEntity):Intent

        data object OnAdd : Intent

        data class OnCheckedTodo(val todoEntity: TodoEntity) : Intent

        data object OnFetchTodos : Intent

        data class OnDeleteTodo(val todoEntity: TodoEntity) : Intent

        data object OnFetchCompletedTodos : Intent

        data object OnFetchActiveTodos:Intent
    }

    sealed interface Effect {
        data class OnShowError(val message: String) : Effect

        data class OnShowSuccess(val message:String):Effect
    }

    data class State(
        val query: String = "",
        val allTodos: List<TodoEntity> = emptyList(),
        val completedTodos: List<TodoEntity> = emptyList(),
        val activeTodos: List<TodoEntity> = emptyList(),
        val selectedId: Int = -1,
        val isEditIntent: Boolean = false
    )
}