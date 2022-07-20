package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.data.model.signin.SignInResponseData
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.data.model.signup.UserNicknameResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("user")
    suspend fun postSignUp(
        @Body body: SignUpRequestData
    ): SignUpResponseData

    @GET("user/mail")
    suspend fun getUserEmailVerify(
        @Query("userEmail") userEmail: String
    ): UserEmailResponseData

    @GET("user/nicknamecheck")
    suspend fun getUserNicknameVerify(
        @Query("userNickname") nickname: String
    ): UserNicknameResponseData

    @POST("user/signin")
    suspend fun postSignIn(
        @Body body: SignInRequestData
    ): SignInResponseData
}