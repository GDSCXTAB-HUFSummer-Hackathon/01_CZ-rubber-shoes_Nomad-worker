package com.comjeong.nomadworker.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id") val categoryId: String,
    @SerializedName("thumbnail_image_url") val thumbnailUrl: String,
    @SerializedName("location") val location: String
)
