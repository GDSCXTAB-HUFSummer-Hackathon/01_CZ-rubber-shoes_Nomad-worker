package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.feed.TotalFeedsResponseData
import com.comjeong.nomadworker.data.model.mypage.UserTotalFeedsResponseData
import retrofit2.http.GET

interface FeedApi {

    @GET("feeds/total")
    suspend fun getTotalFeeds(): TotalFeedsResponseData

    @GET("feeds/usertotal")
    suspend fun getUserTotalFeed(): UserTotalFeedsResponseData
}