package com.comjeong.nomadworker.data.datasource.source.place

import com.comjeong.nomadworker.data.model.place.PlaceDetailResponseData

interface PlaceDetailDataSource {

    suspend fun getPlaceDetailById(placeId: Long): PlaceDetailResponseData
}