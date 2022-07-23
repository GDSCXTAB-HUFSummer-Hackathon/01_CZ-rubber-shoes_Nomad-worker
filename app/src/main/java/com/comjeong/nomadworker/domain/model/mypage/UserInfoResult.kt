package com.comjeong.nomadworker.domain.model.mypage

import com.google.gson.annotations.SerializedName

data class UserInfoResult(
    val message: String,
    val status: Int,
    val data: Result?
) {
    data class Result(
        val userNickname: String?,
        val userProfileUrl: String?
    )
}
