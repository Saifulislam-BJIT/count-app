package com.saiful.myapplication.database

class CountRepository(private val countDao: CountDao) {

    suspend fun addUser(count: Count) {
        countDao.addCount(count)
    }
}