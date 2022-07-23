package com.comjeong.nomadworker.data.model.mypage

import com.google.gson.annotations.SerializedName

data class UserTotalFeedsResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result?
) {
    data class Result(
        @SerializedName("u_nickname") val userNickname: String,
        @SerializedName("u_image") val userImageUrl: String,
        @SerializedName("feedList") val feedList: List<Feed>
    ) {
        data class Feed(
            @SerializedName("f_image") val feedImageUrl: String,
            @SerializedName("f_id") val feedId: Long
        )
    }
}
