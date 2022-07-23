package com.comjeong.nomadworker.domain.repository.mypage

import com.comjeong.nomadworker.domain.model.mypage.UserInfoResult

interface MyPageRepository {

    suspend fun getUserInfo(): UserInfoResult
}