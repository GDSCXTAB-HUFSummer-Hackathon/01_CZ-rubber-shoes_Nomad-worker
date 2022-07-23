package com.comjeong.nomadworker.data.datasource.remote.home

import com.comjeong.nomadworker.data.datasource.source.home.HomeRemoteDataSource
import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData
import com.comjeong.nomadworker.data.network.api.PlaceApi

class HomeRemoteDataSourceImpl(private val api: PlaceApi) : HomeRemoteDataSource {
    override suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResponseData {
        return api.getPlaceByLocationCategory(categoryName)
    }
}