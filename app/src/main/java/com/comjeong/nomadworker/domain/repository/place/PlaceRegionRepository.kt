package com.comjeong.nomadworker.domain.repository.place

import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult

interface PlaceRegionRepository {
    suspend fun getPlaceByLocationName(categoryName: String): LocationPlaceResult
}