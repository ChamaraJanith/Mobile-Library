package com.example.booknest_mobile_library

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ClubDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create layout programmatically
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        // Get data from intent
        val clubName = intent.getStringExtra("CLUB_NAME") ?: "Book Club"
        val bookTitle = intent.getStringExtra("BOOK_TITLE") ?: "Unknown Book"
        val memberCount = intent.getIntExtra("MEMBER_COUNT", 0)

        // Create and add TextViews
        val titleView = TextView(this).apply {
            text = clubName
            textSize = 24f
            setTextColor(android.graphics.Color.BLACK)
            setPadding(0, 0, 0, 16)
        }

        val bookView = TextView(this).apply {
            text = "Currently Reading: $bookTitle"
            textSize = 16f
            setTextColor(android.graphics.Color.GRAY)
            setPadding(0, 0, 0, 8)
        }

        val memberView = TextView(this).apply {
            text = "$memberCount members"
            textSize = 14f
            setTextColor(android.graphics.Color.GRAY)
            setPadding(0, 0, 0, 16)
        }

        val descriptionView = TextView(this).apply {
            text = "Welcome to $clubName! Join our discussions and discover new books together."
            textSize = 14f
            setTextColor(android.graphics.Color.BLACK)
        }

        layout.addView(titleView)
        layout.addView(bookView)
        layout.addView(memberView)
        layout.addView(descriptionView)

        setContentView(layout)
    }
}
