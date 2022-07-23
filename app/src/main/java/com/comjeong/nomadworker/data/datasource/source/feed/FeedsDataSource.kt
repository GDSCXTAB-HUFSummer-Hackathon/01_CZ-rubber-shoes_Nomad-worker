package com.comjeong.nomadworker.data.datasource.source.feed

import com.comjeong.nomadworker.data.model.feed.TotalFeedsResponseData

interface FeedsDataSource {

    suspend fun getTotalFeeds(): TotalFeedsResponseData
}