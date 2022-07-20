package com.comjeong.nomadworker.data.datasource.remote

import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.data.model.signup.UserNicknameResponseData
import com.comjeong.nomadworker.data.network.api.AuthApi

class SignUpRemoteDataSourceImpl(private val authApi: AuthApi) : SignUpDataSource {
    override suspend fun postSignUp(body: SignUpRequestData): SignUpResponseData {
        return authApi.postSignUp(body)
    }

    override suspend fun getUserEmailVerify(email: String): UserEmailResponseData {
        return authApi.getUserEmailVerify(email)
    }

    override suspend fun getUserNicknameVerify(nickname: String): UserNicknameResponseData {
        return authApi.getUserNicknameVerify(nickname)
    }
}