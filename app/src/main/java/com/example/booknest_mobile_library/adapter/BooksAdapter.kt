package com.example.booknest_mobile_library.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booknest_mobile_library.R
import com.example.booknest_mobile_library.model.Book

class BooksAdapter(private val context: Context) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {
    private var books: List<Book> = emptyList()

    fun setBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book_simple, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvBookTitle)
        private val tvAuthor: TextView = itemView.findViewById(R.id.tvBookAuthor)
        private val ivBookCover: ImageView? = itemView.findViewById(R.id.ivBookCover)
        private val btnInfo: Button? = itemView.findViewById(R.id.btnInfoLink)

        fun bind(book: Book) {
            tvTitle.text = book.title
            tvAuthor.text = book.authors

            ivBookCover?.let { imageView ->
                Glide.with(context)
                    .load(book.imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_gallery)
                    .into(imageView)
            }

            btnInfo?.setOnClickListener {
                if (book.infoLink.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.infoLink))
                    context.startActivity(intent)
                }
            }
        }
    }
}
