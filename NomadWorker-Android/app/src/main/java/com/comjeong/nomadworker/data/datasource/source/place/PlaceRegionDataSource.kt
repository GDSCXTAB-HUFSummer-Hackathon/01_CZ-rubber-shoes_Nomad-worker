package com.comjeong.nomadworker.data.datasource.source.place

import com.comjeong.nomadworker.data.model.place.LocationPlaceResponseData

interface PlaceRegionDataSource {

    suspend fun getPlaceByLocationCategory(locationName: String): LocationPlaceResponseData
}