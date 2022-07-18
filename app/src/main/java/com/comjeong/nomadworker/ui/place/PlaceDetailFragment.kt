package com.comjeong.nomadworker.ui.place

import android.os.Bundle
import android.view.View
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentPlaceDetailBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp

class PlaceDetailFragment : BaseFragment<FragmentPlaceDetailBinding>(R.layout.fragment_place_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        binding.tbPlaceDetail.setNavigationOnClickListener {
            navigateUp()
        }
    }
}