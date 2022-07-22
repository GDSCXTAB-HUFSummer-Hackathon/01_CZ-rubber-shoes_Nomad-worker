package com.comjeong.nomadworker.data.repository.location

import com.comjeong.nomadworker.data.datasource.source.UserLocationDataSource
import com.comjeong.nomadworker.data.mapper.UserLocationMapper
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.model.location.UpdateCurrentLocationResult
import com.comjeong.nomadworker.domain.repository.location.UserLocationRepository

class UserLocationRepositoryImpl(private val dataSource : UserLocationDataSource) : UserLocationRepository {

    override suspend fun updateCurrentLocation(body: UpdateCurrentLocationRequestData
    ): UpdateCurrentLocationResult {
        return  UserLocationMapper.mapToUpdateCurrentLocationResult(dataSource.updateCurrentLocation(body))
    }
}