package com.comjeong.nomadworker.data.network

import com.comjeong.nomadworker.common.addHeader
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor() : Interceptor {
    private lateinit var accessToken: String

    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String? = NomadSharedPreferences.getAccessToken()

        if (!token.isNullOrEmpty()) {
            accessToken = token
        }

        val request = chain.request()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", accessToken)

        return chain.proceed(request)
    }
}