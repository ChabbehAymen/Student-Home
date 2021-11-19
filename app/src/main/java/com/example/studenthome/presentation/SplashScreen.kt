package com.example.studenthome.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.studenthome.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private var TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            val intent = Intent(this, PreviewActivity::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }
}