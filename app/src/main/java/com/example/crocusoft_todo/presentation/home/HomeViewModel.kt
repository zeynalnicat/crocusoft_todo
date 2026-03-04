package com.example.crocusoft_todo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crocusoft_todo.core.AppErrors
import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.data.mapper.toEntity
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity
import com.example.crocusoft_todo.domain.usecase.CheckTodoUseCase
import com.example.crocusoft_todo.domain.usecase.FetchCompletedUseCase
import com.example.crocusoft_todo.domain.usecase.FetchTodosUseCase
import com.example.crocusoft_todo.domain.usecase.InsertTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchTodosUseCase: FetchTodosUseCase,
    private val insertTodoUseCase: InsertTodoUseCase,
    private val fetchCompletedUseCase: FetchCompletedUseCase,
    private val checkTodoUseCase: CheckTodoUseCase,
) :
    ViewModel() {

    private val _state: MutableStateFlow<HomeContract.State> =
        MutableStateFlow(HomeContract.State())

    private val _effect: MutableSharedFlow<HomeContract.Effect> = MutableSharedFlow()

    val effect = _effect.asSharedFlow()

    val state = _state.asStateFlow()

    fun onIntent(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.OnAdd -> {
                onAdd()
            }

            is HomeContract.Intent.OnSetQuery -> {
                viewModelScope.launch {
                    _state.emit(_state.value.copy(query = intent.query))
                }
            }

            is HomeContract.Intent.OnCheckedTodo -> {
                onCheckTodo(intent.todoEntity.id, !intent.todoEntity.isCompleted)
            }

            is HomeContract.Intent.OnDeleteTodo -> {}
            HomeContract.Intent.OnFetchCompletedTodos -> {
                onFetchCompletedTodos()
            }

            HomeContract.Intent.OnFetchTodos -> {
                onFetchTodos()
            }

            HomeContract.Intent.OnFetchActiveTodos -> {
                onFetchActives()
            }
        }
    }

    private fun onCheckTodo(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            when (val result = checkTodoUseCase(id, isCompleted)) {
                is Result.Error -> {
                    _effect.emit(HomeContract.Effect.OnShowError(result.message))
                }

                is Result.Success<*> -> {
                    onFetchTodos()
                }
            }
        }
    }

    private fun onFetchActives() {
//        viewModelScope.launch {
//            when (val result = fetchCompletedUseCase(isCompleted = false)) {
//                is Result.Error -> {
//                    _effect.emit(HomeContract.Effect.OnShowError(result.message))
//                }
//
//                is Result.Success<List<TodoEntity>> -> {
//                    _state.emit(_state.value.copy(activeTodos = result.data))
//                }
//            }
//        }

        viewModelScope.launch {
            _state.emit(_state.value.copy(
                activeTodos = _state.value.allTodos.filter { !it.isCompleted }
            ))
        }
    }

    private fun onFetchCompletedTodos() {

//        viewModelScope.launch {
//            when (val result = fetchCompletedUseCase()) {
//                is Result.Error -> {
//                    _effect.emit(HomeContract.Effect.OnShowError(result.message))
//                }
//
//                is Result.Success<List<TodoEntity>> -> {
//                    _state.emit(_state.value.copy(completedTodos = result.data))
//                }
//            }
//        }

        viewModelScope.launch {
            _state.emit(_state.value.copy(
                completedTodos = _state.value.allTodos.filter { it.isCompleted }
            ))
        }



    }


    private fun onAdd() {

        if (_state.value.query.isEmpty()) {
            viewModelScope.launch {
                _effect.emit(HomeContract.Effect.OnShowError(AppErrors.emptyField))
            }
            return
        }

        viewModelScope.launch {
            when (val result =
                insertTodoUseCase(
                    TodoEntity(
                        0,
                        taskName = _state.value.query,
                        isCompleted = false
                    )
                )) {
                is Result.Error -> {
                    _effect.emit(HomeContract.Effect.OnShowError(result.message))
                }

                is Result.Success<*> -> {
                    _effect.emit(HomeContract.Effect.OnShowSuccess("Successfully added!"))
                    _state.emit(_state.value.copy(query = ""))
                    onFetchTodos()
                }
            }
        }
    }

    private fun onFetchTodos() {
        viewModelScope.launch {
            when (val result = fetchTodosUseCase()) {
                is Result.Error -> {
                    _effect.emit(HomeContract.Effect.OnShowError(result.message))
                }

                is Result.Success<List<TodoEntity>> -> {

                    _state.emit(_state.value.copy(allTodos = result.data.sortedBy { todoEntity -> !todoEntity.isCompleted }))
                }

            }
        }
    }

}