package com.comjeong.nomadworker.data.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result
) {
    data class Result(
        @SerializedName("nickname") val userNickname: String,
        @SerializedName("token") val accessToken: String,
        @SerializedName("latitude") val latitude: Float,
        @SerializedName("longitude") val longitude: Float
    )
}
