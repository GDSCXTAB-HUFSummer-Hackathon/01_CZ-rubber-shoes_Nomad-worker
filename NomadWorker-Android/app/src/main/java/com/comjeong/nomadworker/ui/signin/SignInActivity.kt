package com.comjeong.nomadworker.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.databinding.ActivitySignInBinding
import com.comjeong.nomadworker.model.UserInfo
import com.comjeong.nomadworker.ui.MainActivity
import com.comjeong.nomadworker.ui.common.BaseActivity
import com.comjeong.nomadworker.ui.signup.SignUpActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val viewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindViews()

        observeLoginSuccess()
        observeMessage()
    }


    private fun observeMessage() {
        viewModel.message.observe(this, EventObserver<String> { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun observeLoginSuccess() {
        viewModel.isLoginSuccess.observe(this, EventObserver<Boolean> { isLoginSuccess ->
            if (isLoginSuccess) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        })
    }

    private fun bindViews() {
        binding.btnSignIn.setOnClickListener {
            signIn()
        }

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun signIn() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        viewModel.email = email
        viewModel.password = password
        viewModel.signIn()
    }
}