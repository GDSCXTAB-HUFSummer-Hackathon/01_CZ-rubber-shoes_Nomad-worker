package com.comjeong.nomadworker.domain.repository.home

import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult
import com.comjeong.nomadworker.domain.model.home.RecommendPlaceResult
import com.comjeong.nomadworker.domain.model.home.UpdateCurrentLocationResult
import com.comjeong.nomadworker.domain.model.place.NearbyPlaceResult

interface HomeRepository {

    suspend fun getLocationCategory(): LocationCategoryResult

    suspend fun updateCurrentLocation(body : UpdateCurrentLocationRequestData): UpdateCurrentLocationResult

    suspend fun getNearbyPlace(latitude: Float, longitude: Float): NearbyPlaceResult

    suspend fun getRecommendPlace(): RecommendPlaceResult
}