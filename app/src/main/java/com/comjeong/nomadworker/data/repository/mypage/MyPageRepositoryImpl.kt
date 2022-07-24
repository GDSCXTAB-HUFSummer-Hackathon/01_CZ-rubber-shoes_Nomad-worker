package com.comjeong.nomadworker.data.repository.mypage

import com.comjeong.nomadworker.data.datasource.source.mypage.MyPageDataSource
import com.comjeong.nomadworker.data.mapper.FeedMapper
import com.comjeong.nomadworker.data.mapper.MyPageMapper
import com.comjeong.nomadworker.domain.model.feed.UserTotalFeedResult
import com.comjeong.nomadworker.domain.model.mypage.UserFeedDetailResult
import com.comjeong.nomadworker.domain.model.mypage.UserInfoResult
import com.comjeong.nomadworker.domain.repository.mypage.MyPageRepository

class MyPageRepositoryImpl(private val dataSource: MyPageDataSource) : MyPageRepository {

    override suspend fun getUserInfo(): UserInfoResult {
        return MyPageMapper.mapToUserInfoResult(dataSource.getUserInfo())
    }

    override suspend fun getUserTotalFeed(): UserTotalFeedResult {
        return MyPageMapper.mapToUserTotalFeedResult(dataSource.getUserTotalFeed())
    }

    override suspend fun getUserFeedDetail(feedId: Long): UserFeedDetailResult {
        return MyPageMapper.mapToUserFeedDetailResult(dataSource.getUserFeedDetail(feedId))
    }
}