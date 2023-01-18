package com.saiful.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.saiful.myapplication.database.Count
import com.saiful.myapplication.database.CountDatabase
import com.saiful.myapplication.database.CountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountViewModel(application: Application) : AndroidViewModel(application){
    private var _count = 0
    val count = MutableLiveData<Int>()

    val repository: CountRepository

    init {
        val countDao = CountDatabase.getDatabase(application).countDao()
        repository = CountRepository(countDao)
    }

    fun addCount() {
        count.value = _count++
        val count = Count(0, _count)
        for (i in 8..10) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.addUser(count)
            }
        }

        Log.d("TAG", "addCount: called")
    }
}