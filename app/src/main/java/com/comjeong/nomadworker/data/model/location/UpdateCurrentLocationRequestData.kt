package com.comjeong.nomadworker.data.model.location

import com.google.gson.annotations.SerializedName

data class UpdateCurrentLocationRequestData(
    @SerializedName("latitude") val latitude : Float,
    @SerializedName("longitude") val longitude : Float
)
