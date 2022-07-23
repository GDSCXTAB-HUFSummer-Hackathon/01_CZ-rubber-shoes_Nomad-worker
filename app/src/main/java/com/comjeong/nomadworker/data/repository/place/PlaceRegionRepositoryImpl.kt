package com.comjeong.nomadworker.data.repository.place

import com.comjeong.nomadworker.data.datasource.source.place.PlaceRegionRemoteDataSource
import com.comjeong.nomadworker.data.mapper.PlaceMapper
import com.comjeong.nomadworker.domain.model.place.LocationPlaceResult
import com.comjeong.nomadworker.domain.repository.place.PlaceRegionRepository

class PlaceRegionRepositoryImpl(private val placeRegionRemoteDataSource: PlaceRegionRemoteDataSource) : PlaceRegionRepository {
    override suspend fun getPlaceByLocationName(categoryName: String): LocationPlaceResult {
        return PlaceMapper.mapToLocationPlaceResult(placeRegionRemoteDataSource.getPlaceByLocationCategory(categoryName))
    }
}