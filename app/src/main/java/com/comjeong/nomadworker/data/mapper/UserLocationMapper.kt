package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.domain.model.location.UpdateCurrentLocationResult

object UserLocationMapper {

    fun mapToUpdateCurrentLocationResult(responseData: UpdateCurrentLocationResponseData
    ): UpdateCurrentLocationResult {
        return UpdateCurrentLocationResult(
            message = responseData.message,
            status = responseData.status
        )
    }
}