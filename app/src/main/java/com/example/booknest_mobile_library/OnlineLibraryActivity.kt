package com.example.booknest_mobile_library

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booknest_mobile_library.R
import com.example.booknest_mobile_library.adapter.BooksAdapter
import com.example.booknest_mobile_library.repository.BookRepository

class OnlineLibraryActivity : AppCompatActivity() {

    // Declare these at class level:
    private val bookRepository = BookRepository()
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var rvBooks: RecyclerView
    private lateinit var etSearch: EditText

    // Define your API key here:
    private val googleBooksApiKey = "YOUR_GOOGLE_BOOKS_API_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_library)

        // Initialize RecyclerView and Adapter
        rvBooks = findViewById(R.id.rvOnlineBooks)
        booksAdapter = BooksAdapter(this)
        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = booksAdapter

        etSearch = findViewById(R.id.etSearchOnlineBooks)
        etSearch.setOnEditorActionListener { _, _, _ ->
            val query = etSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                searchBooks(query)
            }
            true
        }

        // Load default books
        searchBooks("fiction")
    }

    private fun searchBooks(query: String) {
        bookRepository.searchBooks(
            query = query,
            apiKey = googleBooksApiKey,        // Now resolves
            onResult = { books ->
                booksAdapter.setBooks(books)   // Now resolves
            },
            onError = { error ->
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        )
    }
}
