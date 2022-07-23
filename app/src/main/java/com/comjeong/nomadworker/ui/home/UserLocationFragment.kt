package com.comjeong.nomadworker.ui.home

import android.location.*
import android.location.Location
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.databinding.FragmentUserLocationBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class UserLocationFragment : BaseFragment<FragmentUserLocationBinding>(R.layout.fragment_user_location),
    OnMapReadyCallback,
    GoogleMap.OnMyLocationClickListener,
    GoogleMap.OnMyLocationButtonClickListener
{
    private val viewModel: UserLocationViewModel by sharedViewModel()

    private lateinit var mGoogleMap: GoogleMap
    private lateinit var mMapView: MapView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMapView = binding.mvMap
        mMapView.onCreate(savedInstanceState)
        mMapView.getMapAsync(this)

        bindRequestUpdateLocation()
        observeButtonUpdateLocation()
        observePossibilityUpdate()
    }

    override fun onStart() {
        super.onStart()
        mMapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView.onStop()
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mMapView.onSaveInstanceState(outState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        initUserLocation()
        val currentLocation = getSavedUserLocation()

        mGoogleMap = googleMap
        mGoogleMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        mGoogleMap.apply {
            moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, Constants.CAMERA_ZOOM))
            val options = MarkerOptions()
            options.position(currentLocation)
            this.addMarker(options)
        }

        showCurrentLocationAddress()
        handleNextButton(false)

        mGoogleMap.isMyLocationEnabled = true
        mGoogleMap.setOnMyLocationButtonClickListener(this)
        mGoogleMap.setOnMyLocationClickListener(this)
    }

    // 사용자가 위치 갱신 버튼을 눌렀을 때 콜백
    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(requireActivity(),"본인의 위치 마커를 클릭해주세요.",Toast.LENGTH_SHORT).show()
        return false
    }

    // 사용자가 자신의 위치 마커를 클릭할 때 콜백
    override fun onMyLocationClick(location: Location) {
        try{
            viewModel.latitude = location.latitude
            viewModel.longitude = location.longitude
            showCurrentLocationAddress()
            Log.d("유저의 현재위치 주소", viewModel.userAddress)
        }catch (e : Throwable){
            e.printStackTrace()
        }
    }







    private fun bindRequestUpdateLocation(){
        binding.btnCurrentLocation.setOnClickListener {
            viewModel.updateUserCurrentLocation()
            handleNextButton(false)
        }
    }

    private fun observePossibilityUpdate(){
        viewModel.isPossibleUpdate.observe(viewLifecycleOwner) { isPossible ->
            if (isPossible) {
                binding.tvCurrentLocation.text = viewModel.userAddress
                handleNextButton(true)
            }
        }
    }

    private fun observeButtonUpdateLocation(){
        viewModel.isUpdateLocation.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(requireActivity(), "현재위치를 저장합니다 :)", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireActivity(), "오류입니다. 다시 시도해주세요 :(", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleNextButton(canEnable: Boolean) {
        if (canEnable) {
            binding.btnCurrentLocation.isEnabled = true
            binding.btnCurrentLocation.setBackgroundResource(R.drawable.bg_blue_radius_10)
        } else {
            binding.btnCurrentLocation.isEnabled = false
            binding.btnCurrentLocation.setBackgroundResource(R.drawable.bg_grey06_radius_10)
        }
    }

    private fun initUserLocation() {
        viewModel.latitude = NomadSharedPreferences.getUserLatitude().toDouble()
        viewModel.longitude = NomadSharedPreferences.getUserLongitude().toDouble()
    }

    private fun getSavedUserLocation() : LatLng {
        val latitude = viewModel.latitude
        val longitude = viewModel.longitude
        return LatLng(latitude,longitude)
    }

    private fun showCurrentLocationAddress() {
        try{
            viewModel.setUserLocationAddress(Geocoder(requireActivity()))
        }catch(e : Throwable){
            Timber.d("geoCoder ${e}")
            e.printStackTrace()
        }
        binding.tvCurrentLocation.text = viewModel.userAddress
    }

}