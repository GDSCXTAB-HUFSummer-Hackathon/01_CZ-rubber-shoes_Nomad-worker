package com.comjeong.nomadworker.data.datasource.source

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData

interface SignUpDataSource {
    suspend fun postSignUp(body: SignUpRequestData): SignUpResponseData
}