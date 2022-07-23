package com.comjeong.nomadworker.domain.repository.home

import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult
import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult
import com.comjeong.nomadworker.domain.model.home.UpdateCurrentLocationResult

interface HomeRepository {

    suspend fun getLocationCategory(): LocationCategoryResult

    suspend fun updateCurrentLocation(body : UpdateCurrentLocationRequestData): UpdateCurrentLocationResult

    suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResult
}