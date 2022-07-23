package com.comjeong.nomadworker.domain.model.location

import com.google.gson.annotations.SerializedName

data class UpdateCurrentLocationResult(
    @SerializedName("message") val message : String,
    @SerializedName("status") val status : Int
)
