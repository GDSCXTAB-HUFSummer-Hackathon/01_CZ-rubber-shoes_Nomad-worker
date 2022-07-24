package com.comjeong.nomadworker.ui.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.domain.model.signin.SignInResult
import com.comjeong.nomadworker.domain.repository.signin.SignInRepository
import com.comjeong.nomadworker.model.UserInfo
import kotlinx.coroutines.launch
import timber.log.Timber

class SignInViewModel(private val repository: SignInRepository) : ViewModel() {
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

    private val _isLoginSuccess: MutableLiveData<Event<Boolean>> = MutableLiveData<Event<Boolean>>()
    val isLoginSuccess: LiveData<Event<Boolean>> = _isLoginSuccess


    private val _message: MutableLiveData<Event<String>> = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>> = _message

    fun signIn() {
        val request = SignInRequestData(email = _email, password = _password)
        Timber.d("$request")

        viewModelScope.launch {
            try {
                val response = repository.postSignIn(request)

                when (response.status) {
                    200 -> {
                        _isLoginSuccess.value = Event(true)
                        _message.value = Event(response.message)
                        setUser(response, true)
                    }
                    else -> {
                        _isLoginSuccess.value = Event(false)
                        _message.value = Event(response.message)
                        setUser(response, false)
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.e("FAILED: $e")
            }
        }
    }

    private fun setUser(response: SignInResult, loginStatus: Boolean) {
        NomadSharedPreferences.setUser(
            UserInfo(
                userNickname = response.data.nickname,
                accessToken = response.data.accessToken,
                latitude = response.data.latitude,
                longitude = response.data.longitude,
                isLogin = loginStatus
            )
        )
    }
}