package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.model.Category

interface HomeDataSource {

    fun getHomeCategory(): Category?
}