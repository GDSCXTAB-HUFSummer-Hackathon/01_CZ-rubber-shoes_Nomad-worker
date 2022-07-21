package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.data.model.signin.SignInResponseData

interface SignInDataSource {
    suspend fun postSignIn(body: SignInRequestData): SignInResponseData
}