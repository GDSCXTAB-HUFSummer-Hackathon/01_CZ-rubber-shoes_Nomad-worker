package com.comjeong.nomadworker.data.datasource.remote

import com.comjeong.nomadworker.data.datasource.source.mypage.MyPageDataSource
import com.comjeong.nomadworker.data.model.mypage.UserInfoResponseData
import com.comjeong.nomadworker.data.network.api.AuthApi

class MyPageRemoteDataSourceImpl(private val api: AuthApi) : MyPageDataSource {

    override suspend fun getUserInfo(): UserInfoResponseData {
        return api.getUserInfo()
    }
}