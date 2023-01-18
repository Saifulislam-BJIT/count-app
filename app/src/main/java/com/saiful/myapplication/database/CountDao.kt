package com.saiful.myapplication.database

import android.content.ClipData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CountDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCount(count: Count)
}