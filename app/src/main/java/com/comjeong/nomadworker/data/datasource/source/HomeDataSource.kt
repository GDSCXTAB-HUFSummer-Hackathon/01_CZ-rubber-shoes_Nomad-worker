package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.model.CategoryList

interface HomeDataSource {

    fun getHomeCategory(): CategoryList?
}