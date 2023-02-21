package com.example.test03_sutthida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        log1.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        s1.s1.setOnClickListener {
            val username = s1.usernamel2.text.toString()
            val password = s1.pass2.text.toString()
            val cpPassword = s1.pass3.text.toString()

            if(username.isNotEmpty() && password.isNotEmpty() && cpPassword.isNotEmpty()){
                if(password == cpPassword){
                    firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this,"Password not Match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}