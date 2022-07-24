package com.comjeong.nomadworker.ui.common

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart

fun AppCompatEditText.textChangesToFlow(): Flow<CharSequence?> {
    return callbackFlow<CharSequence?> {
        val listener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                trySend(s)
            }

            override fun afterTextChanged(s: Editable?) = Unit
        }

        addTextChangedListener(listener)

        awaitClose { removeTextChangedListener(listener) }

    }.onStart {
        emit(text)
    }
}