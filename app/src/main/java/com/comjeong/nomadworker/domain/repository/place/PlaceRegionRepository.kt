package com.comjeong.nomadworker.domain.repository.place

import com.comjeong.nomadworker.domain.model.place.LocationPlaceResult

interface PlaceRegionRepository {
    suspend fun getPlaceByLocationName(categoryName: String): LocationPlaceResult
}