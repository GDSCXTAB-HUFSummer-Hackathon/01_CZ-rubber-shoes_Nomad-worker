package com.comjeong.nomadworker.data.datasource.remote.home

import com.comjeong.nomadworker.data.datasource.source.home.HomeRemoteDataSource
import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.network.api.PlaceApi

class HomeRemoteDataSourceImpl(private val api: PlaceApi) : HomeRemoteDataSource {
    override suspend fun getLocationCategory(): LocationCategoryResponseData {
        return api.getLocationCategory()
    }

    override suspend fun updateCurrentLocation(body: UpdateCurrentLocationRequestData): UpdateCurrentLocationResponseData {
        return api.updateCurrentLocation(body)
    }
}