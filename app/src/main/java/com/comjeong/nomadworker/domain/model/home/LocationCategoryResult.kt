package com.comjeong.nomadworker.domain.model.home

import com.google.gson.annotations.SerializedName

data class LocationCategoryResult(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: List<Category>?
) {
    data class Category(
        @SerializedName("thumbnail_image_url") val thumbnailUrl: String,
        @SerializedName("location") val location: String
    )
}
