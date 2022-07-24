package com.comjeong.nomadworker.ui.place

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.LOCATION_NAME_KEY
import com.comjeong.nomadworker.common.Constants.PLACE_ID_KEY
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.databinding.FragmentPlaceRegionBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateWithBundle
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaceRegionFragment : BaseFragment<FragmentPlaceRegionBinding>(R.layout.fragment_place_region) {

    private val viewModel: PlaceRegionViewModel by viewModel()

    private lateinit var location: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        location = requireArguments().getString(LOCATION_NAME_KEY).toString()

        viewModel.locationName = location
        viewModel.getPlaceWithLocationName()

        setToolbar()
        observePlaceTag()
        setListAdapter()
        observeEvent()
    }

    private fun observeEvent() {
        viewModel.openPlaceDetailEvent.observe(viewLifecycleOwner, EventObserver<Long> { placeId ->
            movePlaceDetail(placeId)
        })
    }

    private fun movePlaceDetail(placeId: Long) {
        navigateWithBundle(R.id.action_place_region_to_place_detail, bundleOf(
            PLACE_ID_KEY to placeId
        ))
    }

    private fun setListAdapter() {
        with(binding.rvRegionPlace) {
            adapter = PlaceRegionAdapter(viewModel).apply {
                viewModel.placeList.observe(viewLifecycleOwner) { placelist ->
                    submitList(placelist)
                }
            }
        }
    }

    private fun observePlaceTag() {
        viewModel.placeTag.observe(viewLifecycleOwner) { placeName ->
            binding.tbNewFeedTopBanner.title = placeName
        }
    }

    private fun setToolbar() {
        binding.tbNewFeedTopBanner.setNavigationOnClickListener {
            navigateUp()
        }
    }
}