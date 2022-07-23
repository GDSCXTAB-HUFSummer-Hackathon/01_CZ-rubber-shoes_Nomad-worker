package com.comjeong.nomadworker.data.datasource.source.home

import com.comjeong.nomadworker.model.CategoryList

interface HomeLocalDataSource {
    fun getHomeCategory(): CategoryList?
}