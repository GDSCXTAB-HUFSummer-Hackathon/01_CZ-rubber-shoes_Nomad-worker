package com.comjeong.nomadworker.ui.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<T: ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {

    lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
    }
}