package com.comjeong.nomadworker.domain.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpResult(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: MemberInfo
) {
    data class MemberInfo(
        @SerializedName("nickname") val userNickname: String,
        @SerializedName("token") val accessToken: String,
        @SerializedName("latitude") val latitude: Float,
        @SerializedName("longitude") val longitude: Float
    )
}
