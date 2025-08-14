package com.example.booknest_mobile_library

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiscoverClubsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_clubs)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)

        // Use string resources instead of hardcoded text
        val screenType = intent.getStringExtra("SCREEN_TYPE")
        if (screenType == "MY_CLUBS") {
            tvTitle.setText(R.string.my_book_clubs)
        } else {
            tvTitle.setText(R.string.discover_book_clubs)
        }

        setupJoinButtons()
    }

    private fun setupJoinButtons() {
        val btn1 = findViewById<Button>(R.id.btnJoinClub1)
        val btn2 = findViewById<Button>(R.id.btnJoinClub2)
        val btn3 = findViewById<Button>(R.id.btnJoinClub3)

        btn1.setOnClickListener {
            Toast.makeText(this, R.string.joined_fantasy, Toast.LENGTH_SHORT).show()
            navigateToDetails("Fantasy Readers United", "The Hobbit", 142)
        }

        btn2.setOnClickListener {
            Toast.makeText(this, R.string.joined_mystery, Toast.LENGTH_SHORT).show()
            navigateToDetails("Mystery Book Club", "Agatha Christie", 89)
        }

        btn3.setOnClickListener {
            Toast.makeText(this, R.string.joined_classic, Toast.LENGTH_SHORT).show()
            navigateToDetails("Classic Literature Society", "Pride and Prejudice", 256)
        }
    }

    private fun navigateToDetails(clubName: String, bookTitle: String, memberCount: Int) {
        val intent = Intent(this, ClubDetailsActivity::class.java)
        intent.putExtra("CLUB_NAME", clubName)
        intent.putExtra("BOOK_TITLE", bookTitle)
        intent.putExtra("MEMBER_COUNT", memberCount)
        startActivity(intent)
    }
}
