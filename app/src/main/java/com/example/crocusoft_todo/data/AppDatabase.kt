package com.example.crocusoft_todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crocusoft_todo.data.service.local.TodoLocalEntity


@Database(version = 1, entities = [TodoLocalEntity::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}