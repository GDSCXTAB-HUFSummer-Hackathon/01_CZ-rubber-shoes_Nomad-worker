package com.comjeong.nomadworker.data.datasource.local.home

import com.comjeong.nomadworker.common.AssetLoader
import com.comjeong.nomadworker.data.datasource.source.HomeDataSource
import com.comjeong.nomadworker.model.Category
import com.comjeong.nomadworker.model.CategoryList
import com.google.gson.Gson

class HomeAssetLocalDataSourceImpl(private val assetLoader: AssetLoader) : HomeDataSource {
    private val gson = Gson()

    override fun getHomeCategory(): CategoryList? {
        return assetLoader.getJsonString("category.json")?.let { homeData ->
            gson.fromJson(homeData, CategoryList::class.java)
        }
    }
}