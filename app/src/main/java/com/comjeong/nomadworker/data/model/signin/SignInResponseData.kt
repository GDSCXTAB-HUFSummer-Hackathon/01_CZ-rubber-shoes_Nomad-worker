package com.comjeong.nomadworker.data.model.signin

import com.google.gson.annotations.SerializedName

data class SignInResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result
) {
    data class Result(
        @SerializedName("nickname") val nickname: String,
        @SerializedName("token") val accessToken: String,
        @SerializedName("latitude") val latitude: Float,
        @SerializedName("longitude") val longitude: Float
    )
}
