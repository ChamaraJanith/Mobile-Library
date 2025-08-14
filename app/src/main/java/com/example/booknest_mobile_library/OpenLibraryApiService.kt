package com.example.booknest.api

import com.example.booknest.model.OpenLibraryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApiService {
    @GET("search.json")
    fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int = 15
    ): Call<OpenLibraryResponse>
}
