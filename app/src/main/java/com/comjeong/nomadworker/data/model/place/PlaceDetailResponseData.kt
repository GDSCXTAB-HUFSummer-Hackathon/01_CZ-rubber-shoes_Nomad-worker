package com.comjeong.nomadworker.data.model.place

import com.google.gson.annotations.SerializedName

data class PlaceDetailResponseData(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Result?
) {
    data class Result(
        @SerializedName("p_id") val placeId: Long,
        @SerializedName("p_cate") val placeCategory: String,
        @SerializedName("p_name") val placeName: String,
        @SerializedName("p_weekt") val placeWeekTime: String,
        @SerializedName("p_weekndt") val placeWeekendTime: String,
        @SerializedName("p_addr") val placeAddress: String,
        @SerializedName("p_image") val placeImageUrl: String,
        @SerializedName("p_latitude") val placeLatitude: Double,
        @SerializedName("p_logitude") val placeLongitude: Double,
        @SerializedName("p_storeType") val placeStoreType: String,
        @SerializedName("menu") val cafeMenu: List<Menu>?,
        @SerializedName("rental_price") val officeRentalPrice: String?
    ) {
        data class Menu(
            @SerializedName("m_menu") val menuName: String,
            @SerializedName("m_price") val menuPrice: String
        )
    }
}
