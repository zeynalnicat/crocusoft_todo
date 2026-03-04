package com.example.crocusoft_todo.data.repository

import com.example.crocusoft_todo.core.AppErrors
import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.data.TodoDao
import com.example.crocusoft_todo.data.mapper.toEntity
import com.example.crocusoft_todo.data.mapper.toLocalEntity
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.data.service.local.TodoLocalEntity
import com.example.crocusoft_todo.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val todoDao: TodoDao) : HomeRepository {
    override suspend fun insert(todoEntity: TodoEntity): Result<Unit> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.insert(todoEntity.toLocalEntity())
                if (response != -1L) {
                    Result.Success(Unit)
                } else {
                    Result.Error(AppErrors.couldNotInsert)
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: AppErrors.unknownError)
            }

        }


    override suspend fun getAll(): Result<List<TodoEntity>> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.getAll()
                Result.Success(response.map { it.toEntity() })

            } catch (e: Exception) {
                Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

    override suspend fun getWhereCompleted(): Result<List<TodoEntity>> =
        withContext(Dispatchers.IO) {
            try {
                val response = todoDao.getAllWhereCompleted()
                Result.Success(response.map { it.toEntity() })
            } catch (e: Exception) {
                Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

    override suspend fun getActives(): Result<List<TodoEntity>> = withContext(Dispatchers.IO) {
        try {
            val response = todoDao.getAllWhereCompleted(isCompleted = false)
            Result.Success(response.map { it.toEntity() })
        } catch (e: Exception) {
            Result.Error(e.message ?: AppErrors.unknownError)
        }
    }

    override suspend fun delete(todoEntity: TodoEntity): Result<Unit> =
        withContext(Dispatchers.IO) {
            try {
                todoDao.delete(todoEntity.toLocalEntity())
                Result.Success(Unit)
            } catch (e: Exception) {
                Result.Error(e.message ?: AppErrors.unknownError)
            }
        }

    override suspend fun checkTodo(id: Int, isCompleted: Boolean): Result<Unit> =
        withContext(Dispatchers.IO) {
            try {
                val result = todoDao.checkTodo(id, isCompleted)
                if (result != 0) {
                    Result.Success(Unit)
                } else {
                    Result.Error(AppErrors.unknownError)
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: AppErrors.unknownError)
            }
        }
}