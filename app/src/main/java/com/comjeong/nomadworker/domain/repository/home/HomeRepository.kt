package com.comjeong.nomadworker.domain.repository.home

import com.comjeong.nomadworker.model.CategoryList

interface HomeRepository {

    fun getHomeCategory(): CategoryList?
}