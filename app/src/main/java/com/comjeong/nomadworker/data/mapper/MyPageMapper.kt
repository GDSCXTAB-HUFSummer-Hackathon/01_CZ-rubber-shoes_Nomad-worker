package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.mypage.UserInfoResponseData
import com.comjeong.nomadworker.data.model.mypage.UserTotalFeedsResponseData
import com.comjeong.nomadworker.domain.model.feed.UserTotalFeedResult
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

    fun mapToUserTotalFeedResult(body: UserTotalFeedsResponseData): UserTotalFeedResult {
        return UserTotalFeedResult(
            message = body.message,
            status = body.status,
            data = UserTotalFeedResult.Result(
                feedList = body.data?.feedList?.map { feed ->
                    UserTotalFeedResult.Result.Feed(
                        feedImageUrl = feed.feedImageUrl,
                        feedId = feed.feedId
                    )
                }
            )
        )
    }
}