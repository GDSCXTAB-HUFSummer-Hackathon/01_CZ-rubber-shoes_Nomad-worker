package com.comjeong.nomadworker.data.model.home

import com.google.gson.annotations.SerializedName

data class UpdateCurrentLocationResponseData(
    @SerializedName("message") val message : String,
    @SerializedName("status") val status : Int
)
