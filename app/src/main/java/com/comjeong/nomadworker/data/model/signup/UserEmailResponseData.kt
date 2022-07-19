package com.comjeong.nomadworker.data.model.signup

import com.google.gson.annotations.SerializedName

data class UserEmailResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result
) {
    data class Result(
        @SerializedName("code") val verificationCode: String
    )
}
