package com.comjeong.nomadworker.ui.place

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.LOCATION_NAME_KEY
import com.comjeong.nomadworker.databinding.FragmentPlaceRegionBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import timber.log.Timber

class PlaceRegionFragment : BaseFragment<FragmentPlaceRegionBinding>(R.layout.fragment_place_region) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val location = requireArguments().get(LOCATION_NAME_KEY)
        Timber.d("$location")

    }
}