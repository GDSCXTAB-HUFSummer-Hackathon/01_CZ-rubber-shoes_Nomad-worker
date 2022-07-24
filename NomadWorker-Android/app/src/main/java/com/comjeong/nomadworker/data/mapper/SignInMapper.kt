package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.signin.SignInResponseData
import com.comjeong.nomadworker.domain.model.signin.SignInResult

object SignInMapper {
    fun mapToSignInResult(body: SignInResponseData): SignInResult {
        return SignInResult(
            message = body.message,
            status = body.status,
            data = SignInResult.Result(
                nickname = body.data.nickname,
                accessToken = body.data.accessToken,
                latitude = body.data.latitude,
                longitude = body.data.longitude
            )
        )
    }
}