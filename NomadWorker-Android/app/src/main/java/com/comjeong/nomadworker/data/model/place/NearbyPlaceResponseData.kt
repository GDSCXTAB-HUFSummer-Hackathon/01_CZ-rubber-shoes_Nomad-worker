package com.comjeong.nomadworker.data.model.place

import com.google.gson.annotations.SerializedName

data class NearbyPlaceResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: List<Result>?
) {
    data class Result(
        @SerializedName("p_id") val placeId: Long,
        @SerializedName("p_cate") val placeCategory: String,
        @SerializedName("p_name") val placeName: String,
        @SerializedName("p_image") val placeThumbnailUrl: String
    )
}
