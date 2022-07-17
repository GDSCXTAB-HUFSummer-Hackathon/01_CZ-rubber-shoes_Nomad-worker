package com.comjeong.nomadworker.data.datasource.home

import com.comjeong.nomadworker.model.Category

interface HomeDataSource {

    fun getHomeCategory(): Category?
}