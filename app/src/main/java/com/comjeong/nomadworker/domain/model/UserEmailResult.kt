package com.comjeong.nomadworker.domain.model

import com.google.gson.annotations.SerializedName

data class UserEmailResult(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result
) {
    data class Result(
        @SerializedName("code") val verificationCode: String
    )
}
