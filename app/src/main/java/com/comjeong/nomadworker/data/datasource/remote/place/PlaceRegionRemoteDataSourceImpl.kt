package com.comjeong.nomadworker.data.datasource.remote.place

import com.comjeong.nomadworker.data.datasource.source.place.PlaceRegionRemoteDataSource
import com.comjeong.nomadworker.data.model.place.LocationPlaceResponseData
import com.comjeong.nomadworker.data.network.api.PlaceApi

class PlaceRegionRemoteDataSourceImpl(private val api: PlaceApi) : PlaceRegionRemoteDataSource {
    override suspend fun getPlaceByLocationCategory(locationName: String): LocationPlaceResponseData {
        return api.getPlaceByLocationName(locationName)
    }
}