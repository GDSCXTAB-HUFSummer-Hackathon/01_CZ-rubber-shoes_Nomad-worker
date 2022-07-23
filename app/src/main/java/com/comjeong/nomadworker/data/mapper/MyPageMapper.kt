package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.mypage.UserInfoResponseData
import com.comjeong.nomadworker.domain.model.mypage.UserInfoResult

object MyPageMapper {
    fun mapToUserInfoResult(body: UserInfoResponseData): UserInfoResult {
        return UserInfoResult(
            message = body.message,
            status = body.status,
            data = UserInfoResult.Result(
                userNickname = body.data?.userNickname,
                userProfileUrl = body.data?.userProfileUrl
            )
        )
    }
}