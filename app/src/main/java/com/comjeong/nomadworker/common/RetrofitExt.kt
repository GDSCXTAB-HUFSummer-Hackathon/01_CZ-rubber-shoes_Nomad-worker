package com.comjeong.nomadworker.common

import okhttp3.Request

fun Request.addHeader(name: String, value: String): Request {
    return this.newBuilder().addHeader(name, value).build()
}