package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData
import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult

object HomeMapper {
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
}