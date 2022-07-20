package com.comjeong.nomadworker.data.model.signin

import com.google.gson.annotations.SerializedName

data class SignInRequestData(
    @SerializedName("u_email") val email: String,
    @SerializedName("u_password") val password: String
)