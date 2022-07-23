package com.comjeong.nomadworker.data.model.home

import com.google.gson.annotations.SerializedName

data class RecommendPlaceResponseData(
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
