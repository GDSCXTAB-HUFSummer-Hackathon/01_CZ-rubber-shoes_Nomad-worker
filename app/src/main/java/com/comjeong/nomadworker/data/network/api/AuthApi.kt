package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("api/user/signup")
    suspend fun postSignUp(
        @Body body: SignUpRequestData
    ): SignUpResponseData
}