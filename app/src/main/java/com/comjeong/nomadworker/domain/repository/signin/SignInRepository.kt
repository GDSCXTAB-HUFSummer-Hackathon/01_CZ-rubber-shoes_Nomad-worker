package com.comjeong.nomadworker.domain.repository.signin

import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.domain.model.signin.SignInResult

interface SignInRepository {
    suspend fun postSignIn(body: SignInRequestData): SignInResult
}