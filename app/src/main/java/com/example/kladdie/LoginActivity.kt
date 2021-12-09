package com.example.kladdie

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var forgotPassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        //        hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()

        forgotPassword = findViewById(R.id.forgot_password)

        val btnLogin :Button= findViewById(R.id.loginBtn)
        val email = findViewById<EditText>(R.id.login_email)
        val password = findViewById<EditText>(R.id.login_password)
        val notuser = findViewById<TextView>(R.id.createAccount)

        notuser.setOnClickListener {
            val createacc = Intent(this, RegisterActivity::class.java)
            startActivity(createacc)
        }

        btnLogin.setOnClickListener{
            if (TextUtils.isEmpty(email.text.toString().trim())){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show()
            }else if (TextUtils.isEmpty(password.text.toString().trim())) {
                Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show()
            }else {mAuth!!.signInWithEmailAndPassword(email.text.toString().trim(), password.text.toString().trim())
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult> { task ->
                        if (task.isSuccessful){
                            val firebaseUser : FirebaseUser = task.result!!.user!!
                            Toast.makeText(this,"You are logged in successfully.",Toast.LENGTH_SHORT).show()
                            val intent =
                                Intent(this,MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                )}
        }

        forgotPassword!!.setOnClickListener{
            val newIntent = Intent(this,ResetPasswordActivity::class.java)
            startActivity(newIntent)
        }

    }

}