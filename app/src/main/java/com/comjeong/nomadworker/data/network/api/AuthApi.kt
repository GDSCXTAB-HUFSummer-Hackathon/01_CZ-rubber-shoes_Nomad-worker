package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.data.model.signup.UserNicknameResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("user/signup")
    suspend fun postSignUp(
        @Body body: SignUpRequestData
    ): SignUpResponseData

    @GET("user/mail")
    suspend fun getUserEmailVerify(
        @Query("userEmail") userEmail: String
    ): UserEmailResponseData

    @GET("user/signup/nickname")
    suspend fun getUserNicknameVerify(
        @Query("nickname") nickname: String
    ): UserNicknameResponseData

}