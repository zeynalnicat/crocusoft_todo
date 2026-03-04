package com.example.crocusoft_todo.domain.usecase

import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity
import com.example.crocusoft_todo.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTodosUseCase @Inject constructor(val homeRepository: HomeRepository) {

    suspend operator fun invoke(): Result<List<TodoEntity>> {
        return homeRepository.getAll()
    }
}