package com.saiful.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count")
data class Count(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val click: Int)
