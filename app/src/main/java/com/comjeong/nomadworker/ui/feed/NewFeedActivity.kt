package com.comjeong.nomadworker.ui.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivityMainBinding
import com.comjeong.nomadworker.databinding.ActivityNewFeedBinding
import com.comjeong.nomadworker.ui.common.BaseActivity

class NewFeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}