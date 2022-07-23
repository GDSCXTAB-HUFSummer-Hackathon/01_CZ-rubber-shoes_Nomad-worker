package com.comjeong.nomadworker.domain.repository.location

import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.domain.model.location.UpdateCurrentLocationResult

interface UserLocationRepository {
    suspend fun updateCurrentLocation(body : UpdateCurrentLocationRequestData):
            UpdateCurrentLocationResult
}