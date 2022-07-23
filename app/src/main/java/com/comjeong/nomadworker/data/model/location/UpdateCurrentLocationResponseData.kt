package com.comjeong.nomadworker.data.model.location

import com.google.gson.annotations.SerializedName

data class UpdateCurrentLocationResponseData(
    @SerializedName("message") val message : String,
    @SerializedName("status") val status : Int
)
