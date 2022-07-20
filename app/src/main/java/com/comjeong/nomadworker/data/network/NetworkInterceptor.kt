package com.comjeong.nomadworker.data.network

import com.comjeong.nomadworker.common.addHeader
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber

class NetworkInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")

        val token: String? = NomadSharedPreferences.getAccessToken()
        if (!token.isNullOrEmpty()) {
            builder.addHeader("Authorization", token)
        }

        val request = builder.build()

        Timber.d("URL : ${request.url}")
        Timber.d("HEADER : ${request.headers}")
        Timber.d("BODY : ${request.body}")

        return chain.proceed(request)
    }
}