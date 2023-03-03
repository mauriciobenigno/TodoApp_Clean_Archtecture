package com.mauriciobenigno.todoapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mauriciobenigno.todoapp.data.ToDoDatabase
import com.mauriciobenigno.todoapp.data.models.ToDoData
import com.mauriciobenigno.todoapp.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()

    private val repository: ToDoRepository

    val getAll: LiveData<List<ToDoData>>


    init {
        repository = ToDoRepository(toDoDao)
        getAll = repository.getAll
    }

    fun insertToDo(toDoData: ToDoData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)
        }
    }

}