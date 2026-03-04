package com.example.crocusoft_todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.crocusoft_todo.domain.local_entity.TodoLocalEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todoEntity: TodoLocalEntity): Long

    @Query("Select * from todos")
    suspend fun getAll(): List<TodoLocalEntity>

    @Query("Select * from todos where isCompleted=:isCompleted")
    suspend fun getAllWhereCompleted(isCompleted: Boolean = true): List<TodoLocalEntity>

    @Delete
    fun delete(todoEntity: TodoLocalEntity)

    @Query("Update todos Set isCompleted=:isCompleted  Where id=:id")
    suspend fun checkTodo(id: Int, isCompleted: Boolean): Int


}