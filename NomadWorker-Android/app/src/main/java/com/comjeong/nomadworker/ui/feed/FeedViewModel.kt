package com.comjeong.nomadworker.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.domain.model.feed.TotalFeedsResult
import com.comjeong.nomadworker.domain.repository.feed.FeedRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class FeedViewModel(private val repository: FeedRepository) : ViewModel() {

    private val _feedList: MutableLiveData<List<TotalFeedsResult.Result>> = MutableLiveData<List<TotalFeedsResult.Result>>()
    val feedList: LiveData<List<TotalFeedsResult.Result>> = _feedList

    fun getTotalFeeds() {
        viewModelScope.launch {
            try {

                val response = repository.getTotalFeeds()

                when (response.status) {
                    200 -> {
                        _feedList.value = response.data
                    }
                    400 -> {
                        _feedList.value = emptyList()
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }


}