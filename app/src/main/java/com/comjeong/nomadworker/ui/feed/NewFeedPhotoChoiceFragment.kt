package com.comjeong.nomadworker.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentNewFeedPhotoChoiceBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setNewFeedCloseDialog
import com.comjeong.nomadworker.ui.common.DialogUtil.setSignUpCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp

class NewFeedPhotoChoiceFragment : BaseFragment<FragmentNewFeedPhotoChoiceBinding>(R.layout.fragment_new_feed_photo_choice){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        bindCancelFeedPosting()
    }

    private fun bindViews(){
        binding.btnDoneToSelectPhoto.setOnClickListener {
            navigate(R.id.action_navigation_select_photo_to_navigation_write_content)
        }
    }

    private fun bindCancelFeedPosting(){
        binding.tbNewFeedTopBanner.setNavigationOnClickListener {
            setNewFeedCloseDialog(requireActivity(),"photoChoice")
        }

        binding.tbNewFeedTopBanner.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.close -> {
                    setNewFeedCloseDialog(requireContext(),"photoChoice")
                    true
                }
                else -> false
            }
        }
    }
}