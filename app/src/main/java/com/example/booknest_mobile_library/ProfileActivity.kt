package com.example.booknest_mobile_library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.booknest_mobile_library.R   // <— IMPORT R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)   // R.layout resolves
    }
}
