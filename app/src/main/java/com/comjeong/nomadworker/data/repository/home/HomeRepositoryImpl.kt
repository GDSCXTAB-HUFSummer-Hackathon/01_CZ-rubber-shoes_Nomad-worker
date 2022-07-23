package com.comjeong.nomadworker.data.repository.home

import com.comjeong.nomadworker.data.datasource.source.home.HomeRemoteDataSource
import com.comjeong.nomadworker.data.mapper.HomeMapper
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult
import com.comjeong.nomadworker.domain.model.home.UpdateCurrentLocationResult
import com.comjeong.nomadworker.domain.model.place.NearbyPlaceResult
import com.comjeong.nomadworker.domain.repository.home.HomeRepository

class HomeRepositoryImpl(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getLocationCategory(): LocationCategoryResult {
        return HomeMapper.mapToLocationCategoryResult(homeRemoteDataSource.getLocationCategory())
    }

    override suspend fun updateCurrentLocation(body: UpdateCurrentLocationRequestData
    ): UpdateCurrentLocationResult {
        return  HomeMapper.mapToUpdateCurrentLocationResult(homeRemoteDataSource.updateCurrentLocation(body))
    }

    override suspend fun getNearbyPlace(latitude: Float, longitude: Float): NearbyPlaceResult {
        return HomeMapper.mapToNearbyPlaceResult(homeRemoteDataSource.getNearbyPlace(latitude, longitude))
    }
}