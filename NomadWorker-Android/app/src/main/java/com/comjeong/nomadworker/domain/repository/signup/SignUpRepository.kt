package com.comjeong.nomadworker.domain.repository.signup

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.model.signup.SignUpResult
import com.comjeong.nomadworker.domain.model.signup.UserEmailResult
import com.comjeong.nomadworker.domain.model.signup.UserNicknameResult

interface SignUpRepository {
    suspend fun postSignUp(body: SignUpRequestData): SignUpResult

    suspend fun getUserEmailVerify(email: String): UserEmailResult

    suspend fun getUserNicknameVerify(nickname: String): UserNicknameResult
}