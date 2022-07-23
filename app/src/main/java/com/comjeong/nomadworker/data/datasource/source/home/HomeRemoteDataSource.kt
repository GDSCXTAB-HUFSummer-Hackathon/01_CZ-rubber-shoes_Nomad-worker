package com.comjeong.nomadworker.data.datasource.source.home

import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.model.place.NearbyPlaceResponseData

interface HomeRemoteDataSource {

    suspend fun getLocationCategory(): LocationCategoryResponseData

    suspend fun updateCurrentLocation(body : UpdateCurrentLocationRequestData): UpdateCurrentLocationResponseData

    suspend fun getNearbyPlace(latitude: Float, longitude: Float): NearbyPlaceResponseData
}