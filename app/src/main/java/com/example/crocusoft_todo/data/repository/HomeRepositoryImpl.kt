package com.example.crocusoft_todo.data.repository

import com.example.crocusoft_todo.core.AppErrors
import com.example.crocusoft_todo.data.TodoDao
import com.example.crocusoft_todo.data.mapper.toLocalEntity
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity
import com.example.crocusoft_todo.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val todoDao: TodoDao) : HomeRepository {
    override suspend fun insert(todoEntity: TodoEntity): com.example.crocusoft_todo.core.di.Result<Unit> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.insert(todoEntity.toLocalEntity())
                if (response != -1L) {
                    com.example.crocusoft_todo.core.di.Result.Success(Unit)
                } else {
                    com.example.crocusoft_todo.core.di.Result.Error(AppErrors.couldNotInsert)
                }
            } catch (e: Exception) {
                com.example.crocusoft_todo.core.di.Result.Error(e.message ?: AppErrors.unknownError)
            }

        }


    override suspend fun getAll(): com.example.crocusoft_todo.core.di.Result<List<TodoLocalEntity>> =
        withContext(Dispatchers.IO) {
            try {
                val response =  todoDao.getAll()
                com.example.crocusoft_todo.core.di.Result.Success(response)

            } catch (e: Exception) {
                com.example.crocusoft_todo.core.di.Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

    override suspend fun getWhereCompleted(): com.example.crocusoft_todo.core.di.Result<List<TodoLocalEntity>> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.getAllWhereCompleted()
                com.example.crocusoft_todo.core.di.Result.Success(response)
            } catch (e: Exception) {
                com.example.crocusoft_todo.core.di.Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

    override suspend fun delete(todoEntity: TodoEntity): com.example.crocusoft_todo.core.di.Result<Unit> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.delete(todoEntity.toLocalEntity())
                com.example.crocusoft_todo.core.di.Result.Success(Unit)
            } catch (e: Exception) {
                com.example.crocusoft_todo.core.di.Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

}