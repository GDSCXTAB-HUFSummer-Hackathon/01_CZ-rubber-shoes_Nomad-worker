package com.comjeong.nomadworker.ui.permission

import android.content.Intent
import android.os.Bundle
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivityCheckPermissionBinding
import com.comjeong.nomadworker.ui.MainActivity
import com.comjeong.nomadworker.ui.common.BaseActivity

class CheckPermissionActivity : BaseActivity<ActivityCheckPermissionBinding>(R.layout.activity_check_permission) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}