package com.comjeong.nomadworker.data.datasource.source.home

import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData

interface HomeRemoteDataSource {

    suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResponseData
}