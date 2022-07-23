package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.feed.TotalFeedsResponseData
import retrofit2.http.GET

interface FeedApi {

    @GET("feeds/total")
    suspend fun getTotalFeeds(): TotalFeedsResponseData
}