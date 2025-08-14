package com.example.booknest_mobile_library.api

import com.example.booknest.model.GoogleBooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApiService {
    @GET("volumes")
    fun searchBooks(
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults: Int = 15
    ): Call<GoogleBooksResponse>
}
