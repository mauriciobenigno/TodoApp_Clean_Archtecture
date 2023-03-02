package com.mauriciobenigno.todoapp.data

import androidx.room.TypeConverter
import com.mauriciobenigno.todoapp.data.models.Priority

class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String) : Priority {
        return Priority.valueOf(priority)
    }

}