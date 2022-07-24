package com.comjeong.nomadworker.domain.repository.place

import com.comjeong.nomadworker.domain.model.place.PlaceDetailResult

interface PlaceDetailRepository {

    suspend fun getPlaceDetailById(placeId: Long) : PlaceDetailResult
}