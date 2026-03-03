package com.example.crocusoft_todo.core.di

import android.content.Context
import androidx.room.Room
import com.example.crocusoft_todo.data.AppDatabase
import com.example.crocusoft_todo.data.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(context, "crocusoft").build()
    }

    @Provides
    fun provideTodoDao(roomDatabase: AppDatabase): TodoDao = roomDatabase.todoDao()
}