package com.mauriciobenigno.todoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {
        @Volatile
        private var instance: ToDoDatabase? = null

        fun getDatabase(context: Context) : ToDoDatabase {
            instance?.let {
                return it
            } ?: kotlin.run {
                synchronized(this){
                    val instanceTemp = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "database"
                    ).build()

                    instance = instanceTemp
                    return instanceTemp
                }
            }
        }
    }
}