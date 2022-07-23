package com.comjeong.nomadworker.data.datasource.source.mypage

import com.comjeong.nomadworker.data.model.mypage.UserInfoResponseData

interface MyPageDataSource {

    suspend fun getUserInfo(): UserInfoResponseData
}