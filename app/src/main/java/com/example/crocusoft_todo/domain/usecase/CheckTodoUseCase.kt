package com.example.crocusoft_todo.domain.usecase

import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.domain.repository.HomeRepository
import javax.inject.Inject

class CheckTodoUseCase @Inject constructor(val homeRepository: HomeRepository) {

    suspend operator fun invoke(id: Int, isCompleted: Boolean): Result<Unit> {
        return homeRepository.checkTodo(id, isCompleted)
    }
}