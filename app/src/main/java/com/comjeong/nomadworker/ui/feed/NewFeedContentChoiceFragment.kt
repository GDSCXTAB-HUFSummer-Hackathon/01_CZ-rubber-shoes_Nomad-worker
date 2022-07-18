package com.comjeong.nomadworker.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentNewFeedContentChoiceBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setNewFeedCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp

class NewFeedContentChoiceFragment : BaseFragment<FragmentNewFeedContentChoiceBinding>(R.layout.fragment_new_feed_content_choice) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        bindCancelFeedPosting()
    }

    private fun bindViews(){
        binding.btnDoneToWriteContent.setOnClickListener {
            navigate(R.id.action_navigation_write_content_to_navigation_write_choice_place)
        }

        binding.tbNewFeedTopBanner.setNavigationOnClickListener {
            navigateUp()
        }
    }

    private fun bindCancelFeedPosting(){
        binding.tbNewFeedTopBanner.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.close -> {
                    setNewFeedCloseDialog(requireContext(),"contentChoice")
                    true
                }
                else -> false
            }
        }
    }
}