package com.comjeong.nomadworker.domain.model

import com.comjeong.nomadworker.model.UserInfo
import com.google.gson.annotations.SerializedName

data class SignUpResult(
    @SerializedName("data") val data: MemberInfo
) {
    data class MemberInfo(
        @SerializedName("nickname") val userNickname: String,
        @SerializedName("token") val accessToken: String,
        @SerializedName("latitude") val latitude: Float,
        @SerializedName("longitude") val longitude: Float
    )
}
