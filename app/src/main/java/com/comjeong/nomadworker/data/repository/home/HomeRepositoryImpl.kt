package com.comjeong.nomadworker.data.repository.home

import com.comjeong.nomadworker.data.datasource.local.home.HomeAssetLocalDataSourceImpl
import com.comjeong.nomadworker.domain.repository.home.HomeRepository
import com.comjeong.nomadworker.model.CategoryList

class HomeRepositoryImpl(private val homeLocalDataSource: HomeAssetLocalDataSourceImpl) : HomeRepository {

    override fun getHomeCategory(): CategoryList? {
        return homeLocalDataSource.getHomeCategory()
    }
}