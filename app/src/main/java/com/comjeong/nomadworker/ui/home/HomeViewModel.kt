package com.comjeong.nomadworker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comjeong.nomadworker.domain.repository.home.HomeRepository
import com.comjeong.nomadworker.model.Category

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    private val _homeCategory: MutableLiveData<List<Category>> = MutableLiveData<List<Category>>()
    val homeCategory: LiveData<List<Category>> = _homeCategory

    init {
        loadHomeCategoryData()
    }

    fun loadHomeCategoryData() {
        val homeCategory = repository.getHomeCategory()

        homeCategory?.let { category ->
            _homeCategory.value = category.categoryList
        }
    }
}