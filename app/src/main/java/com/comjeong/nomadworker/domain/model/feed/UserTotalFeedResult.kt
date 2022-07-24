package com.comjeong.nomadworker.domain.model.feed

import com.google.gson.annotations.SerializedName

data class UserTotalFeedResult(
    val message: String,
    val status: Int,
    val data: Result?
) {
    data class Result(
        val feedList: List<Feed>?
    ) {
        data class Feed(
            val feedImageUrl: String?,
            val feedId: Long?
        )
    }
}