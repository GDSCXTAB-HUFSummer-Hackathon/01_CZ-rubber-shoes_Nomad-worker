package com.comjeong.nomadworker.ui.feed

import android.os.Bundle
import android.view.View
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentFeedBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate

class FeedFragment : BaseFragment<FragmentFeedBinding>(R.layout.fragment_feed) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindCreateFeedPage()

    }

    private fun bindCreateFeedPage(){
        binding.btnNewFeed.setOnClickListener {
            navigate(R.id.action_navigation_feed_to_newFeedActivity)
        }
    }

}