package com.example.kladdie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val home : ImageView = findViewById(R.id.homeButton)
        val favs : FloatingActionButton = findViewById(R.id.touchfav)
        val profile : ImageView = findViewById(R.id.profile)

        home.setOnClickListener {
            val home = Intent(this, DiscoverActivity::class.java)
            startActivity(home)
        }
        favs.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        profile.setOnClickListener {
            val openOrder = Intent(this, ProfileActivity::class.java)
            startActivity(openOrder)
        }
    }
}