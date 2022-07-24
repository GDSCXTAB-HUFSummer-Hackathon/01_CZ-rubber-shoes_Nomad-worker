package com.comjeong.nomadworker.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.domain.model.feed.UserTotalFeedResult
import com.comjeong.nomadworker.domain.model.mypage.UserFeedDetailResult
import com.comjeong.nomadworker.domain.model.mypage.UserInfoResult
import com.comjeong.nomadworker.domain.repository.mypage.MyPageRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyPageViewModel(private val repository: MyPageRepository) : ViewModel() {

    private var _feedId: Long = 0
    var feedId: Long = _feedId
        set(value) {
            _feedId = value
            field = value
        }

    private val _userInfo: MutableLiveData<UserInfoResult.Result> = MutableLiveData<UserInfoResult.Result>()
    val userInfo: LiveData<UserInfoResult.Result> = _userInfo

    private val _userFeedList: MutableLiveData<List<UserTotalFeedResult.Result.Feed>> = MutableLiveData<List<UserTotalFeedResult.Result.Feed>>()
    val userFeedList: LiveData<List<UserTotalFeedResult.Result.Feed>> = _userFeedList

    private val _openFeedDetailEvent: MutableLiveData<Event<Long>> = MutableLiveData<Event<Long>>()
    val openFeedDetailEvent: LiveData<Event<Long>> = _openFeedDetailEvent

    private val _userFeedDetail: MutableLiveData<UserFeedDetailResult.Result> = MutableLiveData<UserFeedDetailResult.Result>()
    val userFeedDetail: LiveData<UserFeedDetailResult.Result> = _userFeedDetail

    fun getUserInfo() {
        viewModelScope.launch {
            try {
                val response = repository.getUserInfo()

                when (response.status) {
                    200 -> {
                        _userInfo.value = response.data
                    }
                    400 -> {
                        _userInfo.value = response.data
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }

    fun getUserTotalFeed() {
        viewModelScope.launch {
            try {
                val response = repository.getUserTotalFeed()

                when (response.status) {
                    200 -> {
                        _userFeedList.value = response.data?.feedList
                    }
                    400 -> {
                        _userFeedList.value = emptyList()
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }

    fun getUserFeedDetail() {
        viewModelScope.launch {
            try {
                val response = repository.getUserFeedDetail(_feedId)

                when (response.status) {
                    200 -> {
                        _userFeedDetail.value = response.data
                    }
                    400 -> {
                        _userFeedDetail.value = response.data
                    }
                }
                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }

    fun openFeedDetailByFeedId(feedId: Long) {
        _openFeedDetailEvent.value = Event(feedId)
    }

}