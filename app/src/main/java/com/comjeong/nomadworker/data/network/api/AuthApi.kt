package com.comjeong.nomadworker.data.network.api

import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationResponseData
import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.data.model.signin.SignInResponseData
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.data.model.signup.SignUpResponseData
import com.comjeong.nomadworker.data.model.signup.UserEmailResponseData
import com.comjeong.nomadworker.data.model.signup.UserNicknameResponseData
import com.google.android.gms.location.LocationSettingsResponse
import retrofit2.http.*

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

    @PUT("user/geographic")
    suspend fun updateCurrentLocation(
        @Body body : UpdateCurrentLocationRequestData
    ) : UpdateCurrentLocationResponseData
}