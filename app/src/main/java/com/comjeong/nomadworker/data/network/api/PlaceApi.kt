package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.common.Constants.BASE_URL
import com.comjeong.nomadworker.data.model.home.LocationPlaceResponseData
import com.comjeong.nomadworker.data.network.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceApi {

    @GET("place/location")
    suspend fun getPlaceByLocationCategory(
        @Query("locationCategory") categoryName: String
    ): LocationPlaceResponseData

    companion object {
        private const val baseUrl = BASE_URL

        fun create(): PlaceApi {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addNetworkInterceptor(NetworkInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(PlaceApi::class.java)
        }
    }
}

