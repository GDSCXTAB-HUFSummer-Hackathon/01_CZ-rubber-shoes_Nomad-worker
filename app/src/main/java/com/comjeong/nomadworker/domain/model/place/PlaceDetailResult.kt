package com.comjeong.nomadworker.domain.model.place

data class PlaceDetailResult(
    val message: String,
    val status: Int,
    val data: Result?
) {
    data class Result(
        val placeId: Long?,
        val placeCategory: String?,
        val placeName: String?,
        val placeWeekTime: String?,
        val placeWeekendTime: String?,
        val placeAddress: String?,
        val placeImageUrl: String?,
        val placeLatitude: Double?,
        val placeLongitude: Double?,
        val placeStoreType: String?,
        val placeUrl: String?
    )
}