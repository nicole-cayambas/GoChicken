package com.example.gochicken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username :EditText = findViewById(R.id.edit_username)
        val password :EditText = findViewById(R.id.edit_password)
        val btnLogin :Button = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            if(username.text.toString().equals("admin")&&
                password.text.toString().equals("admin")){
                val intent = Intent(this, HomeActivity::class.java)
                val msg = intent.putExtra("name", username.text.toString())
                startActivity(intent)
            }else {
                val snackbar = Snackbar.make(it, "incorrect username or password", Snackbar.LENGTH_SHORT).setAction("Action", null)
                snackbar.show()
            }
        }
    }
}
