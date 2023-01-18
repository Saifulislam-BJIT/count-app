package com.saiful.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Count::class], version = 1, exportSchema = false)
abstract class CountDatabase : RoomDatabase() {

    abstract fun countDao(): CountDao

    companion object {
        @Volatile
        private var INSTANCE: CountDatabase? = null
        fun getDatabase(context: Context): CountDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountDatabase::class.java,
                    "count_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}