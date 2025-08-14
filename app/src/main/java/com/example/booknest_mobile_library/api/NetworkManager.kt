package com.example.booknest_mobile_library.api

import com.example.booknest.api.OpenLibraryApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private const val GOOGLE_BOOKS_BASE_URL = "https://www.googleapis.com/books/v1/"
    private const val OPEN_LIBRARY_BASE_URL = "https://openlibrary.org/"

    val googleBooksApiService: GoogleBooksApiService by lazy {
        Retrofit.Builder()
            .baseUrl(GOOGLE_BOOKS_BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleBooksApiService::class.java)
    }

    val openLibraryApiService: OpenLibraryApiService by lazy {
        Retrofit.Builder()
            .baseUrl(OPEN_LIBRARY_BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApiService::class.java)
    }
}
