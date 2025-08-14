package com.example.booknest_mobile_library.repository

import com.example.booknest_mobile_library.model.Book

class BookRepository {
    fun searchBooks(
        query: String,
        apiKey: String,
        onResult: (List<Book>) -> Unit,
        onError: (String) -> Unit
    ) {
        // Simulate search results for now
        val sampleBooks = listOf(
            Book(
                id = "1",
                title = "The Hobbit",
                authors = "J.R.R. Tolkien",
                description = "A fantasy adventure novel",
                imageUrl = "",
                infoLink = ""
            ),
            Book(
                id = "2",
                title = "Harry Potter",
                authors = "J.K. Rowling",
                description = "A magical adventure",
                imageUrl = "",
                infoLink = ""
            )
        )
        onResult(sampleBooks)
    }
}
