package com.comjeong.nomadworker.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.comjeong.nomadworker.common.AssetLoader
import com.comjeong.nomadworker.data.datasource.local.home.HomeAssetLocalDataSourceImpl
import com.comjeong.nomadworker.data.repository.home.HomeRepositoryImpl
import com.comjeong.nomadworker.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val dataSource = HomeAssetLocalDataSourceImpl(AssetLoader(context))
                val repository = HomeRepositoryImpl(dataSource)
                HomeViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}