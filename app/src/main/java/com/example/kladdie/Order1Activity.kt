package com.example.kladdie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Order1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order1)

        val backTo : ImageView = findViewById(R.id.back_arrow)
        backTo.setOnClickListener {
            val discover = Intent(this,DiscoverActivity::class.java)
            startActivity(discover)
        }
    }
}