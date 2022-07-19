package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.data.model.signup.UserNicknameResponseData

interface SignUpDataSource {
    suspend fun postSignUp(body: SignUpRequestData): SignUpResponseData

    suspend fun getUserEmailVerify(email: String): UserEmailResponseData

    suspend fun getUserNicknameVerify(nickname: String): UserNicknameResponseData
}