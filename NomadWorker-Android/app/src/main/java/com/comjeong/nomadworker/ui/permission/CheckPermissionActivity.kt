package com.comjeong.nomadworker.ui.permission

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivityCheckPermissionBinding
import com.comjeong.nomadworker.ui.MainActivity
import com.comjeong.nomadworker.ui.common.BaseActivity
import com.comjeong.nomadworker.ui.permission.UserPermission.isGrantedPermission
import com.comjeong.nomadworker.ui.permission.UserPermission.requestAllPermission


class CheckPermissionActivity : BaseActivity<ActivityCheckPermissionBinding>(R.layout.activity_check_permission) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindClickedButton()
    }

    private fun bindClickedButton(){
        binding.btnPermission.setOnClickListener {
            requestAllPermission()
        }

        binding.btnNext.setOnClickListener {
            moveToStartActivity()
        }
    }

    private fun moveToStartActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(grantResults.isNotEmpty() && isGrantedPermission(grantResults)){
            Toast.makeText(this,"권한 허용이 완료됐습니다 :)",Toast.LENGTH_SHORT ).show()
        }
    }
}