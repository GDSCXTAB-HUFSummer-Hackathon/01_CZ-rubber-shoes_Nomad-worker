package com.comjeong.nomadworker.data.datasource.remote.location

import com.comjeong.nomadworker.data.datasource.source.UserLocationDataSource
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.network.api.AuthApi

class UserLocationRemoteDataSourceImpl(private val authApi: AuthApi) : UserLocationDataSource {
    override suspend fun updateCurrentLocation(body: UpdateCurrentLocationRequestData): UpdateCurrentLocationResponseData {
        return authApi.updateCurrentLocation(body)
    }
}