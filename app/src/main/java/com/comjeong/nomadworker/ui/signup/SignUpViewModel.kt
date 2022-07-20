package com.comjeong.nomadworker.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.repository.signup.SignUpRepository
import com.comjeong.nomadworker.domain.model.signup.SignUpResult
import com.comjeong.nomadworker.model.UserInfo
import kotlinx.coroutines.launch
import timber.log.Timber

class SignUpViewModel(private val repository: SignUpRepository) : ViewModel() {
    private var _email: String = ""
    var email: String = _email
        set(value) {
            _email = value
            field = value
        }

    private var _password: String = ""
    var password: String = _password
        set(value) {
            _password = value
            field = value
        }

    private var _nickname: String = ""
    var nickname: String = _nickname
        set(value) {
            _nickname = value
            field = value
        }

    private val _isEmailDuplicated: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isEmailDuplicated: LiveData<Event<Boolean>> = _isEmailDuplicated

    private val _isNickNameDuplicated: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isNicknameDuplicated: LiveData<Event<Boolean>> = _isNickNameDuplicated

    private val _emailCode: MutableLiveData<String> = MutableLiveData<String>()
    val emailCode: LiveData<String> = _emailCode

    private val _isSignUpSuccess: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isSignUpSuccess: LiveData<Event<Boolean>> = _isSignUpSuccess

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

    fun signUp() {
        val request = SignUpRequestData(email = _email, password = _password, nickname = _nickname)
        Timber.d("$request")

        viewModelScope.launch {
            try {
                val response = repository.postSignUp(request)

                when (response.status) {
                    200 -> {
                        _isSignUpSuccess.value = Event(true)
                        setUser(response)
                    }
                    400 -> {
                        _isSignUpSuccess.value = Event(false)
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }
        }
    }

    private fun setUser(response: SignUpResult) {
        NomadSharedPreferences.setUser(
            UserInfo(
                userNickname = response.data.userNickname,
                accessToken = response.data.accessToken,
                latitude = response.data.latitude,
                longitude = response.data.longitude
            )
        )
    }
}