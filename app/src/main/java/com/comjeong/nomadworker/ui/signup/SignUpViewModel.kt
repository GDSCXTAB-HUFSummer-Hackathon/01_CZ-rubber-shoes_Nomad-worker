package com.comjeong.nomadworker.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.domain.SignUpRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SignUpViewModel(private val repository: SignUpRepository) : ViewModel() {

    private val _isEmailDuplicated: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isEmailDuplicated: LiveData<Event<Boolean>> = _isEmailDuplicated

    private val _isNickNameDuplicated: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isNicknameDuplicated: LiveData<Event<Boolean>> = _isNickNameDuplicated

    private val _emailCode: MutableLiveData<String> = MutableLiveData<String>()
    val emailCode: LiveData<String> = _emailCode

    fun checkDuplicateEmail(email: String) {
        viewModelScope.launch {
            try {
                val response = repository.getUserEmailVerify(email)

                if (response.status == 200) {
                    _isEmailDuplicated.value = Event(false)
                    _emailCode.value = response.data.verificationCode
                } else {
                    _isEmailDuplicated.value = Event(true)
                    _emailCode.value = response.data.verificationCode
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }

    fun checkDuplicateNickname(nickname: String) {
        viewModelScope.launch {
            try {
                val response = repository.getUserNicknameVerify(nickname)

                if (response.status == 200) {
                    _isNickNameDuplicated.value = Event(false)
                } else {
                    _isNickNameDuplicated.value = Event(true)
                }
                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }

    }

}