package com.comjeong.nomadworker.domain.model.home

data class LocationCategoryResult(
    val message: String,
    val status: Int,
    val data: List<Category>?
) {
    data class Category(
        val thumbnailUrl: String,
        val location: String
    )
}
