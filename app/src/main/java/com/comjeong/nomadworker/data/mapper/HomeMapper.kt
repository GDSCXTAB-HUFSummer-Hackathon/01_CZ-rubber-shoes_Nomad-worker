package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.model.place.NearbyPlaceResponseData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult
import com.comjeong.nomadworker.domain.model.home.UpdateCurrentLocationResult
import com.comjeong.nomadworker.domain.model.place.NearbyPlaceResult

object HomeMapper {

    fun mapToUpdateCurrentLocationResult(responseData: UpdateCurrentLocationResponseData
    ): UpdateCurrentLocationResult {
        return UpdateCurrentLocationResult(
            message = responseData.message,
            status = responseData.status
        )
    }

    fun mapToLocationCategoryResult(body: LocationCategoryResponseData): LocationCategoryResult {
        return LocationCategoryResult(
            message = body.message,
            status = body.status,
            data = body.data?.map { category ->
                LocationCategoryResult.Category(
                    thumbnailUrl = category.thumbnailUrl,
                    location = category.location
                )
            }
        )
    }

    fun mapToNearbyPlaceResult(body: NearbyPlaceResponseData): NearbyPlaceResult {
        return NearbyPlaceResult(
            message = body.message,
            status = body.status,
            data = body.data?.map { place ->
                NearbyPlaceResult.Result(
                    placeId = place.placeId,
                    placeCategory = place.placeCategory,
                    placeName = place.placeName,
                    placeThumbnailUrl = place.placeThumbnailUrl
                )
            }
        )
    }
}