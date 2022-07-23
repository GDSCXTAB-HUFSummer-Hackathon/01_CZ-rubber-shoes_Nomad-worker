package com.comjeong.nomadworker.domain.model.home

import com.google.gson.annotations.SerializedName

data class UpdateCurrentLocationResult(
    @SerializedName("message") val message : String,
    @SerializedName("status") val status : Int
)
