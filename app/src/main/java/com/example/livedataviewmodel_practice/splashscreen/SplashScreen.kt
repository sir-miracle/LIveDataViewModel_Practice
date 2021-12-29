package com.example.livedataviewmodel_practice.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.livedataviewmodel_practice.MainActivity
import com.example.livedataviewmodel_practice.R

class SplashScreen: AppCompatActivity(){

    lateinit var handler: Handler

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        handler = Handler(Looper.getMainLooper())

        handler.postDelayed({

        val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)//
    }
}