package com.example.viewmodel

import kotlinx.coroutines.delay

class UserRepo {
    suspend fun getUsers(): List<User>{
        delay(8000)
        val users: List<User> = listOf(
            User(1,"Taylor"),
            User(2,"Taro"),
            User(3,"Jane"),
            User(4,"Amy")
        )
        return users
    }
}