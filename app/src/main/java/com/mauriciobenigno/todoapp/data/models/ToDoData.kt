package com.mauriciobenigno.todoapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mauriciobenigno.todoapp.data.models.Priority

@Entity(tableName = "mb_todo")
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var titulo: String,
    var prioridade: Priority,
    var descricao: String
)