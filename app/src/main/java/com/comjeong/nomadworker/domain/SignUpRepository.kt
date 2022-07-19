package com.comjeong.nomadworker.domain

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.model.SignUpResult

interface SignUpRepository {
    suspend fun postSignUp(body: SignUpRequestData): SignUpResult
}