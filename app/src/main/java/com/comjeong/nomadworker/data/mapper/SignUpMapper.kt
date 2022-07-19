package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.domain.model.SignUpResult

object SignUpMapper {

    fun mapToSignUpResult(responseData: SignUpResponseData ): SignUpResult {
        return SignUpResult(
            data = SignUpResult.MemberInfo(
                userNickname = responseData.data.userNickname,
                accessToken = responseData.data.accessToken,
                latitude = responseData.data.latitude,
                longitude = responseData.data.longitude
            )
        )
    }
}