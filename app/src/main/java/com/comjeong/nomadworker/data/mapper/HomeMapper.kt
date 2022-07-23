package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult
import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult
import com.comjeong.nomadworker.domain.model.home.UpdateCurrentLocationResult

object HomeMapper {

    fun mapToUpdateCurrentLocationResult(responseData: UpdateCurrentLocationResponseData
    ): UpdateCurrentLocationResult {
        return UpdateCurrentLocationResult(
            message = responseData.message,
            status = responseData.status
        )
    }

    fun mapToLocationPlaceResult(body: LocationPlaceResponseData): LocationPlaceResult {
        return LocationPlaceResult(
            message = body.message,
            status = body.status,
            data = LocationPlaceResult.Result(
                locationName = body.data?.locationName,
                place = body.data?.place?.map { place ->
                    LocationPlaceResult.Result.Place(
                        placeId = place.placeId,
                        placeName = place.placeName,
                        placeAddress = place.placeAddress,
                        placeWeekTime = place.placeWeekTime,
                        placeWeekEndTime = place.placeWeekEndTime,
                        placeThumbnailImageUrl = place.placeThumbnailImageUrl
                    )
                }
            )
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
}