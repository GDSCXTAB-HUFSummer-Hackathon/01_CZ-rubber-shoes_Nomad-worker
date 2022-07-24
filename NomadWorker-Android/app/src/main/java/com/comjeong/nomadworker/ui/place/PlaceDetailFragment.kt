package com.comjeong.nomadworker.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.CAMERA_ZOOM
import com.comjeong.nomadworker.common.Constants.PLACE_ID_KEY
import com.comjeong.nomadworker.databinding.FragmentPlaceDetailBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PlaceDetailFragment : BaseFragment<FragmentPlaceDetailBinding>(R.layout.fragment_place_detail),
    OnMapReadyCallback {

    private val viewModel: PlaceDetailViewModel by viewModel()
    private var placeLatitude: Double = 0.0
    private var placeLongitude: Double = 0.0


    private lateinit var mGoogleMap: GoogleMap
    private lateinit var mMapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val placeId = requireArguments().getLong(PLACE_ID_KEY)
        Timber.d("$placeId")
        viewModel.placeId = placeId

        viewModel.getPlaceDetailByPlaceId()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        observePlaceDetailInfo()

        mMapView = binding.mvPlaceMap
        mMapView.onCreate(savedInstanceState)
        mMapView.getMapAsync(this)
    }

    private fun observePlaceDetailInfo() {
        viewModel.placeDetailInfo.observe(viewLifecycleOwner) { detailInfo ->
            binding.placeInfo = detailInfo

            placeLatitude = detailInfo.placeLatitude!!
            placeLongitude = detailInfo.placeLongitude!!

            Timber.d("$placeLatitude")
            Timber.d("$placeLongitude")

        }
    }

    private fun bindViews() {
        binding.tbPlaceDetail.setNavigationOnClickListener {
            navigateUp()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {

        val placeLocation = getPlaceLocation()

        mGoogleMap = googleMap
        mGoogleMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        mGoogleMap.apply {
            moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocation, CAMERA_ZOOM))
            val options = MarkerOptions()
            options.position(placeLocation)
            this.addMarker(options)
        }
    }

    private fun getPlaceLocation(): LatLng {
        return LatLng(placeLatitude, placeLongitude)
    }
}