package com.comjeong.nomadworker.ui.home

import android.app.AlertDialog
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.databinding.FragmentHomeBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.ViewModelFactory
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.permission.UserPermission.isGrantedLocationPermission
import com.comjeong.nomadworker.ui.permission.UserPermission.requestLocationPermission
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val locationViewModel : UserLocationViewModel by sharedViewModel()

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setHomeCategoryBanner()
        bindInitCurrentLocation()
        observeCurrentLocation()
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
        locationViewModel.setUserLocationAddress(Geocoder(requireActivity()))
        binding.tvCurrentLocation.text = NomadSharedPreferences.getUserLocation()
    }

    private fun observeCurrentLocation(){
        locationViewModel.isUpdateLocation.observe(viewLifecycleOwner) { isSuccessUpdate ->
            if(isSuccessUpdate){
                binding.tvCurrentLocation.text = NomadSharedPreferences.getUserLocation()
            }
        }
    }

    private fun setHomeCategoryBanner() {
        with(binding.vpCategory) {
            adapter = HomeCategoryAdapter().apply {
                viewModel.homeCategory.observe(viewLifecycleOwner) { category ->
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