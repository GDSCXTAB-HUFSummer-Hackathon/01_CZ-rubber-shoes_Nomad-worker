package com.comjeong.nomadworker.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val userNickname: String,
    val accessToken: String,
    val latitude: Float,
    val longitude: Float
) : Parcelable
