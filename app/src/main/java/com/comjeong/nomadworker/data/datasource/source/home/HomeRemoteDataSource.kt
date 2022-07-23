package com.comjeong.nomadworker.data.datasource.source.home

import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData

interface HomeRemoteDataSource {

    suspend fun getLocationCategory(): LocationCategoryResponseData

    suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResponseData

    suspend fun updateCurrentLocation(body : UpdateCurrentLocationRequestData): UpdateCurrentLocationResponseData
}