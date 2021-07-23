package com.madesubs.myapplication.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madesubs.myapplication.MainActivity
import com.madesubs.myapplication.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import org.koin.android.ext.android.bind

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()


        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)


    }
}