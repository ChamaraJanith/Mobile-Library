package com.example.booknest.model

data class OpenLibraryResponse(
    val docs: List<OpenLibraryBook> = emptyList()
)

data class OpenLibraryBook(
    val key: String = "",
    val title: String = "",
    val author_name: List<String>? = null,
    val first_publish_year: Int? = null,
    val cover_i: Int? = null
)
