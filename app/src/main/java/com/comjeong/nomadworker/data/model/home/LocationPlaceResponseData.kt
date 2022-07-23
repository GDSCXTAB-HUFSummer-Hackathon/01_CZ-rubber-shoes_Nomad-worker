package com.comjeong.nomadworker.data.model.home

import com.google.gson.annotations.SerializedName

data class LocationPlaceResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result?
) {
    data class Result(
        @SerializedName("place_tag") val locationName: String,
        @SerializedName("place") val place: List<Place>
    ) {
        data class Place(
            @SerializedName("p_id") val placeId: Long,
            @SerializedName("p_name") val placeName: String,
            @SerializedName("p_addr") val placeAddress: String,
            @SerializedName("p_weekt") val placeWeekTime: String,
            @SerializedName("p_weekndt") val placeWeekEndTime: String,
            @SerializedName("p_image") val placeThumbnailImageUrl: String
        )
    }
}