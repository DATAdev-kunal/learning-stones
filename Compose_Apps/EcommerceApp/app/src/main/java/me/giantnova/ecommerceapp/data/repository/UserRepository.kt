package me.giantnova.ecommerceapp.data.repository

import me.giantnova.ecommerceapp.data.models.User
import me.giantnova.ecommerceapp.data.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor() {
    private val apiService = RetrofitClient.apiService

    suspend fun login(email: String, password: String): Result<User> {
        return try {
            val loginBody = mapOf(
                "username" to email,
                "password" to password
            )
            val response = withContext(Dispatchers.IO) {
                apiService.login(loginBody)
            }
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Login failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(user: User): Result<User> {
        return try {
            val registerBody = mapOf(
                "email" to user.email,
                "username" to user.username,
                "password" to user.password,
                "name" to mapOf(
                    "firstname" to (user.name?.firstname ?: ""),
                    "lastname" to (user.name?.lastname ?: "")
                ),
                "phone" to (user.phone ?: "")
            )
            val response = withContext(Dispatchers.IO) {
                apiService.register(registerBody)
            }
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Registration failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}