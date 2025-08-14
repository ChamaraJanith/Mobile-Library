package com.example.booknest_mobile_library

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnDiscoverClubs).setOnClickListener {
            startActivity(Intent(this, DiscoverClubsActivity::class.java))
        }

        findViewById<Button>(R.id.btnMyClubs).setOnClickListener {
            val intent = Intent(this, DiscoverClubsActivity::class.java)
            intent.putExtra("SCREEN_TYPE", "MY_CLUBS")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<Button>(R.id.btnOnlineLibrary).setOnClickListener {
            startActivity(Intent(this, OnlineLibraryActivity::class.java))
        }
    }
}
