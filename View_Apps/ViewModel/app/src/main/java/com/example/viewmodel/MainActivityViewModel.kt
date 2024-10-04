package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel :ViewModel(){
    private var userRepo = UserRepo()
    var users: MutableLiveData<List<User>> = MutableLiveData()


     fun getUserData(){
        viewModelScope.launch {
            var result: List<User>? =null
            withContext(Dispatchers.IO){
                result = userRepo.getUsers()
            }
            users.value = result
        }
     }
}