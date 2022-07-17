package com.comjeong.nomadworker.common

import android.content.Context

class AssetLoader(private val context: Context) {

    fun getJsonString(fileName: String): String? {
        return kotlin.runCatching { loadAsset(fileName) }.getOrNull()
    }

    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val byteArray = ByteArray(size)
            inputStream.read(byteArray)
            String(byteArray)
        }
    }
}