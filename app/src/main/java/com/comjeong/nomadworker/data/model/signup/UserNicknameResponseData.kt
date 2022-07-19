package com.comjeong.nomadworker.data.model.signup

import com.google.gson.annotations.SerializedName

data class UserNicknameResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int
)
