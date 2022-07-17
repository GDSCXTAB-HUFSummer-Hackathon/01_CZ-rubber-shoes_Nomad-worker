package com.comjeong.nomadworker.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.comjeong.nomadworker.common.GlideApp

object BindingAdapter {

    @BindingAdapter("imageUrl")
    fun setImageUrl(view: AppCompatImageView, imageUrl: String) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}