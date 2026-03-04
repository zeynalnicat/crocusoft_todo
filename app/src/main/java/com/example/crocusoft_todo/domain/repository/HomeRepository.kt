package com.example.crocusoft_todo.domain.repository

import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity

interface HomeRepository {

    suspend fun insert(todoEntity: TodoEntity): com.example.crocusoft_todo.core.di.Result<Unit>

    suspend fun getAll(): com.example.crocusoft_todo.core.di.Result<List<TodoEntity>>

    suspend fun getWhereCompleted(): com.example.crocusoft_todo.core.di.Result<List<TodoEntity>>

    suspend fun getActives(): com.example.crocusoft_todo.core.di.Result<List<TodoEntity>>

    suspend fun delete(todoEntity: TodoEntity): com.example.crocusoft_todo.core.di.Result<Unit>

    suspend fun checkTodo(
        id: Int,
        isCompleted: Boolean
    ): com.example.crocusoft_todo.core.di.Result<Unit>
}