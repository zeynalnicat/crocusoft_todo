package com.example.crocusoft_todo.domain.usecase

import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.repository.HomeRepository
import javax.inject.Inject

class FetchCompletedUseCase @Inject constructor(val repository: HomeRepository) {

    suspend operator fun invoke(isCompleted: Boolean = true): Result<List<TodoEntity>> {
        if (isCompleted) return repository.getWhereCompleted()

        return repository.getActives()


    }
}