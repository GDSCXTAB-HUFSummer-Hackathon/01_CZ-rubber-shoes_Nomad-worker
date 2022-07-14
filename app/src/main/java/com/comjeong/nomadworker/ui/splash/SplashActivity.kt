package com.comjeong.nomadworker.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.ui.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initSplash()
    }

    private fun initSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            Log.e("Splash", "TEST")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000L)
    }
}