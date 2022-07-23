package com.comjeong.nomadworker.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.comjeong.nomadworker.common.GlideApp

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(view: AppCompatImageView, imageUrl: String) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("nickname")
    fun setNickname(view: AppCompatTextView, nickname: String) {
        view.text = nickname +"님, 오늘은 어디서 근무하시나요?"
    }
}