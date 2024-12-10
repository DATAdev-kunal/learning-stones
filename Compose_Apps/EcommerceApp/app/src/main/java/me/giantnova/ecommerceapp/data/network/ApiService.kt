package me.giantnova.ecommerceapp.data.network

import me.giantnova.ecommerceapp.data.models.Product
import me.giantnova.ecommerceapp.data.models.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1
    ): Response<List<Product>>

    @GET("products/{id}")
    suspend fun getProductDetails(
        @Path("id") productId: Int
    ): Response<Product>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): Response<List<Product>>

    @GET("products")
    suspend fun searchProducts(
        @Query("title") query: String
    ): Response<List<Product>>

    @POST("auth/login")
    suspend fun login(
        @Body loginCredentials: Map<String, String>
    ): Response<User>

    @POST("users")
    suspend fun register(
        @Body userDetails: Map<String, Any>
    ): Response<User>
}