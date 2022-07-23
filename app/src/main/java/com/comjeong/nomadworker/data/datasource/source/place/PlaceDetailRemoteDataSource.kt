package com.comjeong.nomadworker.data.datasource.source.place

import com.comjeong.nomadworker.data.model.place.PlaceDetailResponseData

interface PlaceDetailRemoteDataSource {

    suspend fun getPlaceDetailById(placeId: Long): PlaceDetailResponseData
}