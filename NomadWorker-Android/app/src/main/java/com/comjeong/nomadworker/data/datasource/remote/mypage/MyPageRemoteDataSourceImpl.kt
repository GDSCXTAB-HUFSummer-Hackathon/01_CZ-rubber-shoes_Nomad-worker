package com.comjeong.nomadworker.data.datasource.remote.mypage

import com.comjeong.nomadworker.data.datasource.source.mypage.MyPageDataSource
import com.comjeong.nomadworker.data.model.mypage.UserFeedDetailResponseData
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

    override suspend fun getUserFeedDetail(feedId: Long): UserFeedDetailResponseData {
        return feedApi.getUserFeedDetail(feedId)
    }
}