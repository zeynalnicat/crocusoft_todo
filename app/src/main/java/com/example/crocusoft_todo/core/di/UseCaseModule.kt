package com.example.crocusoft_todo.core.di

import com.example.crocusoft_todo.domain.repository.HomeRepository
import com.example.crocusoft_todo.domain.usecase.CheckTodoUseCase
import com.example.crocusoft_todo.domain.usecase.FetchCompletedUseCase
import com.example.crocusoft_todo.domain.usecase.FetchTodosUseCase
import com.example.crocusoft_todo.domain.usecase.InsertTodoUseCase
import com.example.crocusoft_todo.domain.usecase.RemoveTodoUseCase
import com.example.crocusoft_todo.domain.usecase.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchTodosUseCase(homeRepository: HomeRepository): FetchTodosUseCase =
        FetchTodosUseCase(homeRepository)

    @Provides
    fun provideInsertTodoUseCase(homeRepository: HomeRepository): InsertTodoUseCase =
        InsertTodoUseCase(homeRepository)

    @Provides
    fun provideFetchCompletedTodosUseCase(homeRepository: HomeRepository): FetchCompletedUseCase =
        FetchCompletedUseCase(homeRepository)

    @Provides
    fun provideCheckTodoUseCase(homeRepository: HomeRepository): CheckTodoUseCase =
        CheckTodoUseCase(homeRepository)

    @Provides
    fun provideRemoveTodoUseCase(homeRepository: HomeRepository): RemoveTodoUseCase =
        RemoveTodoUseCase(homeRepository)

    @Provides
    fun provideUpdateTaskUseCase(homeRepository: HomeRepository): UpdateTaskUseCase =
        UpdateTaskUseCase(homeRepository)

}