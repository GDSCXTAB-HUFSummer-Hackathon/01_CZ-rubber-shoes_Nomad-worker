package com.comjeong.nomadworker.data.model.feed

import com.google.gson.annotations.SerializedName

data class TotalFeedsResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: List<Result>?
) {
    data class Result(
        @SerializedName("u_name") val userName: String,
        @SerializedName("u_profile") val userProfile: String,
        @SerializedName("p_id") val placeId: Long,
        @SerializedName("f_id") val feedId: Long,
        @SerializedName("f_image") val feedImageUrl: String,
        @SerializedName("f_content") val feedContent: String,
        @SerializedName("f_like") val feedLike: Int,
        @SerializedName("p_name") val placeName: String
    )
}
