package com.comjeong.nomadworker.data.datasource.remote.place

import com.comjeong.nomadworker.data.datasource.source.place.PlaceDetailDataSource
import com.comjeong.nomadworker.data.model.place.PlaceDetailResponseData
import com.comjeong.nomadworker.data.network.api.PlaceApi

class PlaceDetailRemoteDataSourceImpl(private val api: PlaceApi) : PlaceDetailDataSource {

    override suspend fun getPlaceDetailById(placeId: Long): PlaceDetailResponseData {
        return api.getPlaceDetailById(placeId)
    }
}