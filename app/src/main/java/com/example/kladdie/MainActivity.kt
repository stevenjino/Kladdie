package com.example.kladdie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //        hide status bar'
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Kladdie Worldwide Welcomes You!", Toast.LENGTH_SHORT).show()

        val loginworldwide: Button =findViewById(R.id.login_worldwide)
        loginworldwide.setOnClickListener {
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
        }

        val registerworlwide : Button = findViewById(R.id.signup_worldwide)
        registerworlwide.setOnClickListener {
            val signup = Intent (this, RegisterActivity::class.java)
            startActivity(signup)
        }
    }
}