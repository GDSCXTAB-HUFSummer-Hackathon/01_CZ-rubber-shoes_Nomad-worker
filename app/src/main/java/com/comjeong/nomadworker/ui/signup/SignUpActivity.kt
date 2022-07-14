package com.comjeong.nomadworker.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}