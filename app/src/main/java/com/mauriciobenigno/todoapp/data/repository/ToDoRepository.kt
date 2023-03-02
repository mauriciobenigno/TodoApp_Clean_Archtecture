package com.mauriciobenigno.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.mauriciobenigno.todoapp.data.ToDoDao
import com.mauriciobenigno.todoapp.data.models.ToDoData

class ToDoRepository (private val toDoDao: ToDoDao){

    val getAll: LiveData<List<ToDoData>> = toDoDao.getAll()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertTodo(toDoData)
    }

}