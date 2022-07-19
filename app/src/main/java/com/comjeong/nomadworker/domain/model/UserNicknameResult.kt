package com.comjeong.nomadworker.domain.model

import com.google.gson.annotations.SerializedName

data class UserNicknameResult(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int
)
