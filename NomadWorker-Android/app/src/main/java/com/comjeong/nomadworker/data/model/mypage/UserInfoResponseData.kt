package com.comjeong.nomadworker.data.model.mypage

import com.google.gson.annotations.SerializedName

data class UserInfoResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result?
) {
    data class Result(
        @SerializedName("u_nickname") val userNickname: String,
        @SerializedName("u_image") val userProfileUrl: String
    )
}
