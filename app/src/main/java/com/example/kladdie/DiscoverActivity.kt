package com.example.kladdie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        val home :ImageView = findViewById(R.id.homeButton)
        val order1 : ImageView = findViewById(R.id.order1)
        val order2 : ImageView = findViewById(R.id.order2)
        val order3 : ImageView = findViewById(R.id.order3)
        val order4 : ImageView = findViewById(R.id.order4)

        val favs : FloatingActionButton = findViewById(R.id.touchfav)
        val profile : ImageView = findViewById(R.id.profile)
        val favTouch : ImageView = findViewById(R.id.favTouch)
        val favTouch2 : ImageView = findViewById(R.id.favTouch2)
        val favTouch3 : ImageView = findViewById(R.id.favTouch3)
        val favTouch4 : ImageView = findViewById(R.id.favTouch4)

        val foryou1 : CardView = findViewById(R.id.forYou1)
        val foryou2 : CardView = findViewById(R.id.forYou2)
        val foryou3 : CardView = findViewById(R.id.forYou3)


        home.setOnClickListener {
            val home = Intent(this, DiscoverActivity::class.java)
            startActivity(home)
        }
        order1.setOnClickListener {
            val openOrder = Intent(this, Order1Activity::class.java)
            startActivity(openOrder)
        }
        order2.setOnClickListener {
            val openOrder = Intent(this, Order2Activity::class.java)
            startActivity(openOrder)
        }
        order3.setOnClickListener {
            val openOrder = Intent(this, Order3Activity::class.java)
            startActivity(openOrder)
        }
        order4.setOnClickListener {
            val openOrder = Intent(this, Order4Activity::class.java)
            startActivity(openOrder)
        }
        favs.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        profile.setOnClickListener {
            val openOrder = Intent(this, ProfileActivity::class.java)
            startActivity(openOrder)
        }
        favTouch.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        favTouch2.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        favTouch3.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        favTouch4.setOnClickListener {
            val openOrder = Intent(this, FavoritesActivity::class.java)
            startActivity(openOrder)
        }
        foryou1.setOnClickListener {
            val openOrder = Intent(this, ForYouActivity::class.java)
            startActivity(openOrder)
        }
        foryou2.setOnClickListener {
            val openOrder = Intent(this, ForYouActivity::class.java)
            startActivity(openOrder)
        }
        foryou3.setOnClickListener {
            val openOrder = Intent(this, ForYouActivity::class.java)
            startActivity(openOrder)
        }


    }
}