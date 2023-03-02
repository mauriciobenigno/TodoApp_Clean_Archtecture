package com.mauriciobenigno.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {

    @Query("SELECT * FROM mb_todo ORDER BY id ASC")
    fun getAll(): LiveData<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(toDoData: ToDoData)



}