package com.comjeong.nomadworker.data.repository.feed

import com.comjeong.nomadworker.data.datasource.source.feed.FeedsDataSource
import com.comjeong.nomadworker.data.mapper.FeedMapper
import com.comjeong.nomadworker.domain.model.feed.TotalFeedsResult
import com.comjeong.nomadworker.domain.repository.feed.FeedRepository

class FeedRepositoryImpl(private val dataSource: FeedsDataSource) : FeedRepository {
    override suspend fun getTotalFeeds(): TotalFeedsResult {
        return FeedMapper.mapToTotalFeedsResult(dataSource.getTotalFeeds())
    }
}