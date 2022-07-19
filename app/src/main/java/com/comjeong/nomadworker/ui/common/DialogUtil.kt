package com.comjeong.nomadworker.ui.common

import android.app.AlertDialog
import android.content.Context
import androidx.fragment.app.Fragment
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate

object DialogUtil {

    fun Fragment.setSignUpCloseDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
            .setTitle("회원가입 취소")
            .setMessage("[확인]을 누르면 작성하신 정보가 초기화됩니다.")
            .setPositiveButton("확인") { _, _ ->
                this.requireActivity().finish()
            }
            .setNegativeButton("취소", null)

        builder.show()
    }

    fun Fragment.setNewFeedCloseDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
            .setTitle("피드작성 취소")
            .setMessage("정말로 피드작성을 취소하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                this.requireActivity().finish()
            }
            .setNegativeButton("아니오",null)

        builder.show()
    }
}