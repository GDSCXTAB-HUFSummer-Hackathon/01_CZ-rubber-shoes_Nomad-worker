package com.comjeong.nomadworker.data.repository.home

import com.comjeong.nomadworker.data.datasource.home.HomeAssetLocalDataSourceImpl
import com.comjeong.nomadworker.model.Category

class HomeRepository(private val homeLocalDataSource: HomeAssetLocalDataSourceImpl) {

    fun getHomeCategory(): Category? {
        return homeLocalDataSource.getHomeCategory()
    }
}