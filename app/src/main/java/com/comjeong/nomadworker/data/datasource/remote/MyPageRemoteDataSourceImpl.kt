package com.comjeong.nomadworker.data.datasource.remote

import com.comjeong.nomadworker.data.datasource.source.mypage.MyPageDataSource
import com.comjeong.nomadworker.data.model.mypage.UserInfoResponseData
import com.comjeong.nomadworker.data.model.mypage.UserTotalFeedsResponseData
import com.comjeong.nomadworker.data.network.api.AuthApi
import com.comjeong.nomadworker.data.network.api.FeedApi

class MyPageRemoteDataSourceImpl(private val authApi: AuthApi, private val feedApi: FeedApi) : MyPageDataSource {

    override suspend fun getUserInfo(): UserInfoResponseData {
        return authApi.getUserInfo()
    }

    override suspend fun getUserTotalFeed(): UserTotalFeedsResponseData {
        return feedApi.getUserTotalFeed()
    }
}