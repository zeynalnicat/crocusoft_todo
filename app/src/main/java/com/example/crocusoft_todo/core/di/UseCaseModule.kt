package com.example.crocusoft_todo.core.di

import com.example.crocusoft_todo.domain.repository.HomeRepository
import com.example.crocusoft_todo.domain.usecase.FetchTodosUseCase
import com.example.crocusoft_todo.domain.usecase.InsertTodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchTodosUseCase(homeRepository: HomeRepository): FetchTodosUseCase = FetchTodosUseCase(homeRepository)

    @Provides
     fun provideInsertTodoUseCase(homeRepository: HomeRepository): InsertTodoUseCase =
        InsertTodoUseCase(homeRepository)
}