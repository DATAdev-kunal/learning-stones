package me.giantnova.ecommerceapp.data.repository

import me.giantnova.ecommerceapp.data.models.Product
import me.giantnova.ecommerceapp.data.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepository @Inject constructor() {
    private val apiService = RetrofitClient.apiService

    suspend fun getProducts(page: Int, limit: Int = 10): Result<List<Product>> {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.getProducts(limit = limit, page = page)
            }
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Failed to fetch products"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getProductDetails(productId: Int): Result<Product> {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.getProductDetails(productId)
            }
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to fetch product details"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchProducts(query: String): Result<List<Product>> {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.searchProducts(query)
            }
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Failed to search products"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}