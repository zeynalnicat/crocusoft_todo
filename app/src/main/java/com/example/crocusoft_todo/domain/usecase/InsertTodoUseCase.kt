package com.example.crocusoft_todo.domain.usecase

import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.repository.HomeRepository
import jakarta.inject.Inject


class InsertTodoUseCase @Inject constructor(val homeRepository: HomeRepository) {

    suspend operator fun invoke(todoEntity: TodoEntity): Result<Unit> {
        return homeRepository.insert(todoEntity)
    }
}