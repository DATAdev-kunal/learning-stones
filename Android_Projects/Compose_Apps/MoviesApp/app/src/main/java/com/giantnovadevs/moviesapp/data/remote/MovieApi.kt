package com.giantnovadevs.moviesapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
	@GET("movie/{category}")
	suspend fun getMoviesList(
	    @Path("category") category: String,
		@Query("page") page: Int,
		@Query("api_key") apiKey: Int
	)
	
	companion object{
		const val BASE_URL = "https://api.themovie.db.org/3/"
		const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
		const val  API_KEY = "xxxxxx"
	}
}