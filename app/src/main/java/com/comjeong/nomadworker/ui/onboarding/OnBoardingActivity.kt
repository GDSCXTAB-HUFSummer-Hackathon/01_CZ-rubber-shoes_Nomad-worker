package com.comjeong.nomadworker.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivityOnBoardingBinding
import com.comjeong.nomadworker.ui.common.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>(R.layout.activity_on_boarding) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindViews()

        setViewPagerAdapter()
        setViewPagerPageCallback()
        setIndicatorTabMediator()
    }

    private fun setViewPagerAdapter() {
        binding.vpOnBoardingContent.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> OnBoardingFirstFragment()
                    1 -> OnBoardingSecondFragment()
                    2 -> OnBoardingThirdFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun setViewPagerPageCallback() {
        binding.vpOnBoardingContent.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                setSkipVisibility(position)
                setStartButtonVisibility(position)
            }
        })
    }

    private fun setSkipVisibility(position: Int) {
        binding.tvSkip.visibility = when (position) {
            2 -> View.INVISIBLE
            else -> View.VISIBLE
        }
    }

    private fun setStartButtonVisibility(position: Int) {
        binding.btnStart.visibility = when (position) {
            2 -> View.VISIBLE
            else -> View.GONE
        }
    }

    private fun setIndicatorTabMediator() {
        TabLayoutMediator(binding.tlOnBoarding, binding.vpOnBoardingContent) { _, _ -> }.attach()
    }

    private fun bindViews() {
        binding.btnStart.setOnClickListener {
            // 권한 확인
//            startActivity(Intent(this, ))
//            finish()
        }

        binding.tvSkip.setOnClickListener {
            // 권한 확인
        }
    }
}