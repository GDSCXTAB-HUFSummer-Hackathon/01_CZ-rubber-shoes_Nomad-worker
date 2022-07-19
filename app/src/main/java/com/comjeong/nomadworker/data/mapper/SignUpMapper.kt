package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.domain.model.SignUpResult
import com.comjeong.nomadworker.domain.model.UserEmailResult

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

    fun mapToUserEmailResult(responseData: UserEmailResponseData): UserEmailResult {
        return UserEmailResult(
            message = responseData.message,
            status = responseData.status,
            data = UserEmailResult.Result(
                verificationCode = responseData.data.verificationCode
            )
        )
    }
}