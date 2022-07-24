package com.comjeong.nomadworker.domain.model.mypage

data class UserFeedDetailResult(
    val message: String,
    val status: Int,
    val data: Result?
) {
    data class Result(
        val feedImage: String?,
        val feedContent: String?,
        val feedLike: Int?,
        val userProfileUrl: String?,
        val userNickname: String?
    )
}
