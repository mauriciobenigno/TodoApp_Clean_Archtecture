package com.mauriciobenigno.todoapp.data.models

import com.mauriciobenigno.todoapp.R

enum class Priority(get: Int) {
    HIGH (arrayOf(R.array.prioridades)[0]),
    MEDIUM(arrayOf(R.array.prioridades)[1]),
    LOW(arrayOf(R.array.prioridades)[2])
}