package com.comjeong.nomadworker.domain.repository.home

import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult
import com.comjeong.nomadworker.model.CategoryList

interface HomeRepository {

    fun getHomeCategory(): CategoryList?

    suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResult
}