package com.comjeong.nomadworker.data.datasource.home

import com.comjeong.nomadworker.common.AssetLoader
import com.comjeong.nomadworker.model.Category
import com.google.gson.Gson

class HomeAssetLocalDataSourceImpl(private val assetLoader: AssetLoader) : HomeDataSource {
    private val gson = Gson()

    override fun getHomeCategory(): Category? {
        return assetLoader.getJsonString("category.json")?.let { homeData ->
            gson.fromJson(homeData, Category::class.java)
        }
    }
}