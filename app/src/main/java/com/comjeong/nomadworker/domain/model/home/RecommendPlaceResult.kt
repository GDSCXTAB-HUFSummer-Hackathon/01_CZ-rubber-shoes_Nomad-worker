package com.comjeong.nomadworker.domain.model.home

data class RecommendPlaceResult(
    val message: String,
    val status: Int,
    val data: List<Result>?
) {
    data class Result(
        val placeId: Long,
        val placeCategory: String,
        val placeName: String,
        val placeThumbnailUrl: String
    )
}
