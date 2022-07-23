package com.comjeong.nomadworker.ui.home

import android.location.Geocoder
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.LOCATION_NAME_KEY
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.databinding.FragmentHomeBinding
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult.Category
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateWithBundle
import com.comjeong.nomadworker.ui.permission.UserPermission.isGrantedLocationPermission
import com.comjeong.nomadworker.ui.permission.UserPermission.requestLocationPermission
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setHomeCategoryBanner()
        bindInitCurrentLocation()
        setNearbyPlace()
        observeCurrentLocation()
        setNearbyPlaceAdapter()
        observeEvent()
    }

    private fun setNearbyPlaceAdapter() {
        with(binding.rvNearbyPlace) {
            adapter = NearbyPlaceAdapter().apply {
                viewModel.nearbyPlaceResult.observe(viewLifecycleOwner) { placeResult ->
                    submitList(placeResult)
                }
            }
        }
    }

    private fun setNearbyPlace() {
        viewModel.getNearbyPlace()
    }

    private fun observeEvent() {
        viewModel.openPlaceRegionEvent.observe(viewLifecycleOwner, EventObserver<String> { locationName ->
            movePlaceRegion(locationName)
        })
    }

    private fun movePlaceRegion(locationName: String) {
        navigateWithBundle(R.id.action_home_to_place_region, bundleOf(
            LOCATION_NAME_KEY to locationName
        ))
    }

    private fun bindViews() {
        binding.clCurrentLocation.setOnClickListener {
            if(requireActivity().isGrantedLocationPermission())
                navigate(R.id.action_navigation_home_to_navigation_userLocationFragment)
            else
                Toast.makeText(requireActivity(),"위치 권한을 허용해주세요 :(", Toast.LENGTH_SHORT).show()
                requireActivity().requestLocationPermission()
        }

        binding.nickname = NomadSharedPreferences.getUserNickName()
    }

    private fun bindInitCurrentLocation(){
        viewModel.setUserLocationAddress(Geocoder(requireActivity()))
        binding.tvCurrentLocation.text = NomadSharedPreferences.getUserLocation()
    }

    private fun observeCurrentLocation(){
        viewModel.isUpdateLocation.observe(viewLifecycleOwner) { isSuccessUpdate ->
            if(isSuccessUpdate){
                binding.tvCurrentLocation.text = NomadSharedPreferences.getUserLocation()
            }
        }
    }

    private fun setHomeCategoryBanner() {
        with(binding.vpCategory) {
            adapter = HomeCategoryAdapter(viewModel).apply {
                viewModel.locationCategory.observe(viewLifecycleOwner) { category ->
                    submitList(category)
                }
            }

            val screenWidth = resources.displayMetrics.widthPixels // 스크린 가로 길이
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width) // 페이지 전체 크기
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin) // 페이지 마진 사이즈

            val offset = screenWidth - pageWidth - pageMargin

            offscreenPageLimit = 4
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
        }
    }

}