package com.comjeong.nomadworker.data.datasource.local.home

import com.comjeong.nomadworker.common.AssetLoader
import com.comjeong.nomadworker.data.datasource.source.home.HomeLocalDataSource
import com.comjeong.nomadworker.data.datasource.source.home.HomeRemoteDataSource
import com.comjeong.nomadworker.model.CategoryList
import com.google.gson.Gson

class HomeAssetLocalDataSourceImpl(private val assetLoader: AssetLoader) : HomeLocalDataSource {
    private val gson = Gson()

    override fun getHomeCategory(): CategoryList? {
        return assetLoader.getJsonString("category.json")?.let { homeData ->
            gson.fromJson(homeData, CategoryList::class.java)
        }
    }
}