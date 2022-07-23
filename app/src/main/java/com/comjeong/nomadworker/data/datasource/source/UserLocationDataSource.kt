package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationResponseData

interface UserLocationDataSource {
    suspend fun updateCurrentLocation( body : UpdateCurrentLocationRequestData)
    : UpdateCurrentLocationResponseData
}