package com.comjeong.nomadworker.data.datasource.remote.signin

import com.comjeong.nomadworker.data.datasource.source.SignInDataSource
import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.data.model.signin.SignInResponseData
import com.comjeong.nomadworker.data.network.api.AuthApi

class SignInRemoteDataSourceImpl(private val authApi: AuthApi) : SignInDataSource {
    override suspend fun postSignIn(body: SignInRequestData): SignInResponseData {
        return authApi.postSignIn(body)
    }
}