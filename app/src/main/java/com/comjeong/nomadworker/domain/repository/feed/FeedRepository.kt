package com.comjeong.nomadworker.domain.repository.feed

import com.comjeong.nomadworker.domain.model.feed.TotalFeedsResult

interface FeedRepository {

    suspend fun getTotalFeeds() : TotalFeedsResult
}