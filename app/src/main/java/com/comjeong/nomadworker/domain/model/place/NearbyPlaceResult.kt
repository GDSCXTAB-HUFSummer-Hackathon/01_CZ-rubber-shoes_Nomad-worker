package com.comjeong.nomadworker.domain.model.place

data class NearbyPlaceResult(
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
