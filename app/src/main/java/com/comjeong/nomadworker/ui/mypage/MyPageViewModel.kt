package com.comjeong.nomadworker.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.domain.model.mypage.UserInfoResult
import com.comjeong.nomadworker.domain.repository.mypage.MyPageRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyPageViewModel(private val repository: MyPageRepository) : ViewModel() {

    private val _userInfo: MutableLiveData<UserInfoResult.Result> = MutableLiveData<UserInfoResult.Result>()
    val userInfo: LiveData<UserInfoResult.Result> = _userInfo

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

}