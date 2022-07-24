package com.comjeong.nomadworker.data.model.mypage

import com.google.gson.annotations.SerializedName

data class UserFeedDetailResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result?
) {
    data class Result(
        @SerializedName("f_image") val feedImage: String,
        @SerializedName("f_content") val feedContent: String,
        @SerializedName("f_like_count") val feedLike: Int,
        @SerializedName("like_status") val likeStatus: Boolean,
        @SerializedName("f_time") val feedTime: String,
        @SerializedName("u_image") val userProfileUrl: String,
        @SerializedName("u_nickname") val userNickname: String
    )
}
