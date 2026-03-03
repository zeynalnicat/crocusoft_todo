package com.example.crocusoft_todo.data.mapper

import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity


fun TodoLocalEntity.toEntity(): TodoEntity =
    TodoEntity(id = id, taskName = task, isCompleted)


fun TodoEntity.toLocalEntity(): TodoLocalEntity =
    TodoLocalEntity(id = id, task = taskName, isCompleted)