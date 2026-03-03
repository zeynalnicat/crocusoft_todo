package com.example.crocusoft_todo.domain.local_entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Todos")
data class TodoLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val task: String,
    val isCompleted: Boolean
)
