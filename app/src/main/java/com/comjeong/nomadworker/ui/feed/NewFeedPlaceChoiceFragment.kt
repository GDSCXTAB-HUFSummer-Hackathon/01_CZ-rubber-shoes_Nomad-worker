package com.comjeong.nomadworker.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentNewFeedPlaceChoiceBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setNewFeedCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.comjeong.nomadworker.ui.common.NavigationUtil.popBackStack

class NewFeedPlaceChoiceFragment : BaseFragment<FragmentNewFeedPlaceChoiceBinding>(R.layout.fragment_new_feed_place_choice) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        bindCancelFeedPosting()
    }

    private fun bindViews(){
        binding.tbNewFeedTopBanner.setNavigationOnClickListener {
            navigateUp()
        }

        binding.btnDoneToChoicePlace.setOnClickListener {
            Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    private fun bindCancelFeedPosting(){
        binding.tbNewFeedTopBanner.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.close -> {
                    setNewFeedCloseDialog(requireContext())
                    true
                }
                else -> false
            }
        }
    }
}