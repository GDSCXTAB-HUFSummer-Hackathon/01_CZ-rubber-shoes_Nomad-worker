package com.comjeong.nomadworker.data.mapper

import com.comjeong.nomadworker.data.model.feed.TotalFeedsResponseData
import com.comjeong.nomadworker.domain.model.feed.TotalFeedsResult

object FeedMapper {

    fun mapToTotalFeedsResult(body: TotalFeedsResponseData): TotalFeedsResult {
        return TotalFeedsResult(
            message = body.message,
            status = body.status,
            data = body.data?.map { feed ->
                TotalFeedsResult.Result(
                    userName = feed.userName,
                    userProfile = feed.userProfile,
                    placeId = feed.placeId,
                    feedId = feed.feedId,
                    feedImageUrl = feed.feedImageUrl,
                    feedContent = feed.feedContent,
                    feedLike = feed.feedLike,
                    placeName = feed.placeName
                )
            }
        )
    }
}