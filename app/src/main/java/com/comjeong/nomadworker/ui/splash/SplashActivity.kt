package com.comjeong.nomadworker.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.model.UserInfo
import com.comjeong.nomadworker.ui.MainActivity
import com.comjeong.nomadworker.ui.permission.CheckPermissionActivity
import com.comjeong.nomadworker.ui.signin.SignInActivity
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initSplash()

    }

    private fun initSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            Log.e("Splash", "TEST")
            handleUser()
            finish()
        }, 1000L)
    }

    private fun handleUser() {
        val isLogin = NomadSharedPreferences.getUserIsLogin()
        if (isLogin) startActivity(Intent(this, MainActivity::class.java))
        else startActivity(Intent(this, SignInActivity::class.java))
    }
}