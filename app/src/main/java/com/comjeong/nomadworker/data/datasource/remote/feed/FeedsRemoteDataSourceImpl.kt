package com.comjeong.nomadworker.data.datasource.remote.feed

import com.comjeong.nomadworker.data.datasource.source.feed.FeedsDataSource
import com.comjeong.nomadworker.data.model.feed.TotalFeedsResponseData
import com.comjeong.nomadworker.data.network.api.FeedApi

class FeedsRemoteDataSourceImpl(private val api: FeedApi) : FeedsDataSource {

    override suspend fun getTotalFeeds(): TotalFeedsResponseData {
        return api.getTotalFeeds()
    }
}