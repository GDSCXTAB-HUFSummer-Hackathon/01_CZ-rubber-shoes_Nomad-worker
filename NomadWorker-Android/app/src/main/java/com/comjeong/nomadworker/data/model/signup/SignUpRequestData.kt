package com.comjeong.nomadworker.data.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequestData(
    @SerializedName("u_email") val email: String,
    @SerializedName("u_password") val password: String,
    @SerializedName("u_nickname") val nickname: String
)
