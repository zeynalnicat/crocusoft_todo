package com.example.crocusoft_todo.domain.usecase

import com.example.crocusoft_todo.core.di.Result
import com.example.crocusoft_todo.domain.repository.HomeRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(val repository: HomeRepository) {

    suspend operator fun invoke(id:Int, task:String): Result<Unit>{
        return repository.updateTask(id,task)
    }
}