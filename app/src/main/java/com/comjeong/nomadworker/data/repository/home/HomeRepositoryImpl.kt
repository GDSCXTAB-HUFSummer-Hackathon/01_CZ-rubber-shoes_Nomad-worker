package com.comjeong.nomadworker.data.repository.home

import com.comjeong.nomadworker.data.datasource.local.home.HomeAssetLocalDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.home.HomeRemoteDataSourceImpl
import com.comjeong.nomadworker.data.mapper.HomeMapper
import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult
import com.comjeong.nomadworker.domain.repository.home.HomeRepository
import com.comjeong.nomadworker.model.CategoryList

class HomeRepositoryImpl(
    private val homeLocalDataSource: HomeAssetLocalDataSourceImpl,
    private val homeRemoteDataSource: HomeRemoteDataSourceImpl
) : HomeRepository {

    override fun getHomeCategory(): CategoryList? {
        return homeLocalDataSource.getHomeCategory()
    }

    override suspend fun getPlaceByLocationCategory(categoryName: String): LocationPlaceResult {
        return HomeMapper.mapToLocationPlaceResult(homeRemoteDataSource.getPlaceByLocationCategory(categoryName))
    }
}