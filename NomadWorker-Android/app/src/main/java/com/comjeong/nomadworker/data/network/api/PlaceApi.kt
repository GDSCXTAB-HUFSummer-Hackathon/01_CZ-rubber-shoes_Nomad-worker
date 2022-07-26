package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.home.LocationCategoryResponseData
import com.comjeong.nomadworker.data.model.home.RecommendPlaceResponseData
import com.comjeong.nomadworker.data.model.place.LocationPlaceResponseData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.model.place.NearbyPlaceResponseData
import com.comjeong.nomadworker.data.model.place.PlaceDetailResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface PlaceApi {

    @PUT("user/geographic")
    suspend fun updateCurrentLocation(
        @Body body : UpdateCurrentLocationRequestData
    ) : UpdateCurrentLocationResponseData

    @GET("place/category")
    suspend fun getLocationCategory(): LocationCategoryResponseData

    @GET("place/location")
    suspend fun getPlaceByLocationName(
        @Query("locationCategory") locationName: String
    ): LocationPlaceResponseData

    @GET("place/detail")
    suspend fun getPlaceDetailById(
        @Query("placeId") placeId: Long
    ): PlaceDetailResponseData

    @GET("place/near")
    suspend fun getNearbyPlace(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float
    ): NearbyPlaceResponseData

    @GET("place/recommend")
    suspend fun getRecommendPlace(): RecommendPlaceResponseData
}

