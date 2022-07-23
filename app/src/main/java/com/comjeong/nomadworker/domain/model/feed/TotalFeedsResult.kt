package com.comjeong.nomadworker.domain.model.feed

import com.google.gson.annotations.SerializedName

data class TotalFeedsResult(
    val message: String,
    val status: Int,
    val data: List<Result>?
) {
    data class Result(
        val userName: String,
        val userProfile: String,
        val placeId: Long,
        val feedId: Long,
        val feedImageUrl: String,
        val feedContent: String,
        val feedLike: Int,
        val placeName: String
    )
}

