package com.comjeong.nomadworker.data.repository.place

import com.comjeong.nomadworker.data.datasource.source.place.PlaceDetailDataSource
import com.comjeong.nomadworker.data.mapper.PlaceMapper
import com.comjeong.nomadworker.domain.model.place.PlaceDetailResult
import com.comjeong.nomadworker.domain.repository.place.PlaceDetailRepository

class PlaceDetailRepositoryImpl(private val dataSource: PlaceDetailDataSource) : PlaceDetailRepository {
    override suspend fun getPlaceDetailById(placeId: Long): PlaceDetailResult {
        return PlaceMapper.mapToPlaceDetailResult(dataSource.getPlaceDetailById(placeId))
    }
}