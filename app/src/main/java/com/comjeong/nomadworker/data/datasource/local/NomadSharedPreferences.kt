package com.comjeong.nomadworker.data.datasource.local

import android.content.Context
import android.content.SharedPreferences
import com.comjeong.nomadworker.model.UserInfo

object NomadSharedPreferences {
    private const val ACCESS_TOKEN_KEY = "access_token"
    private const val USER_NICKNAME_KEY = "user_nickname"
    private const val USER_LATITUDE_KEY = "user_latitude"
    private const val USER_LONGITUDE_KEY = "user_longitude"

    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    }

    fun getAccessToken(): String? {
        return preferences.getString(ACCESS_TOKEN_KEY, null)
    }

    fun getUserNickName(): String? {
        return preferences.getString(USER_NICKNAME_KEY, null)
    }

    fun getUserLatitude(): Float {
        return preferences.getFloat(USER_LATITUDE_KEY, 0.0F)
    }

    fun getUserLongitude(): Float {
        return preferences.getFloat(USER_LONGITUDE_KEY, 0.0F)
    }

    private fun setAccessToken(value: String?) {
        preferences.edit().putString(ACCESS_TOKEN_KEY, value).apply()
    }

    private fun setUserNickname(value: String?) {
        preferences.edit().putString(USER_NICKNAME_KEY, value).apply()
    }

    private fun setUserLatitude(value: Float) {
        preferences.edit().putFloat(USER_LATITUDE_KEY, value).apply()
    }

    private fun setUserLongitude(value: Float) {
        preferences.edit().putFloat(USER_LONGITUDE_KEY, value).apply()
    }

    // 로그인
    fun setUser(user: UserInfo?) {
        setUserNickname(user?.userNickname)
        setUserLatitude(user?.latitude!!)
        setUserLongitude(user.longitude)
        setAccessToken(user.accessToken)
    }

    // 토큰 삭제
    fun removeToken() {
        setAccessToken(null)
    }

}