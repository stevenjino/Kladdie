package com.example.kladdie

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.keystore.StrongBoxUnavailableException
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.components.Dependency.required

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //        hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegi = findViewById<Button>(R.id.registerBtn)
        val email = findViewById<EditText>(R.id.register_email)
        val password = findViewById<EditText>(R.id.register_password)
        val conpass = findViewById<EditText>(R.id.confirm_password)
        val alreadyuser = findViewById<TextView>(R.id.alreadyUser)

        alreadyuser.setOnClickListener {
            val alreadyuser = Intent(this, LoginActivity::class.java)
            startActivity(alreadyuser)
        }

        btnRegi.setOnClickListener {
            if (TextUtils.isEmpty(email.text.toString().trim())) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT)
                    .show()
            } else if (TextUtils.isEmpty(password.text.toString().trim())) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT)
                    .show()
            } else if (TextUtils.isEmpty(conpass.text.toString().trim())) {
                Toast.makeText(
                    this,
                    "Please re-enter password",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password.text.toString().trim() != conpass.text.toString().trim()) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT)
                    .show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email.text.toString().trim(),
                    password.text.toString().trim()
                )
                    .addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this,
                                    "You are registered successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent =
                                    Intent(this, DiscoverActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("email", email.text.toString())
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
            }
        }
    }


}