package com.comjeong.nomadworker.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.comjeong.nomadworker.common.AssetLoader
import com.comjeong.nomadworker.data.datasource.local.home.HomeAssetLocalDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.home.HomeRemoteDataSourceImpl
import com.comjeong.nomadworker.data.network.api.PlaceApi
import com.comjeong.nomadworker.data.repository.home.HomeRepositoryImpl
import com.comjeong.nomadworker.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val placeApi = PlaceApi.create()
                val localDataSource = HomeAssetLocalDataSourceImpl(AssetLoader(context))
                val remoteDataSource = HomeRemoteDataSourceImpl(placeApi)
                val repository = HomeRepositoryImpl(localDataSource, remoteDataSource)
                HomeViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}