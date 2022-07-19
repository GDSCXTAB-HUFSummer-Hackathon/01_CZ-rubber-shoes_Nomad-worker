package com.comjeong.nomadworker.domain

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.model.SignUpResult
import com.comjeong.nomadworker.domain.model.UserEmailResult

interface SignUpRepository {
    suspend fun postSignUp(body: SignUpRequestData): SignUpResult

    suspend fun getUserEmailVerify(email: String): UserEmailResult
}