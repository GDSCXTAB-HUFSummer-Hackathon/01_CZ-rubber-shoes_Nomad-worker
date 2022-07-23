package com.comjeong.nomadworker.domain.model.place

data class LocationPlaceResult(
    val message: String,
    val status: Int,
    val data: Result?
) {
    data class Result(
        val locationName: String?,
        val place: List<Place>?
    ) {
        data class Place(
            val placeId: Long,
            val placeName: String,
            val placeAddress: String,
            val placeWeekTime: String,
            val placeWeekEndTime: String,
            val placeThumbnailImageUrl: String
        )
    }
}
