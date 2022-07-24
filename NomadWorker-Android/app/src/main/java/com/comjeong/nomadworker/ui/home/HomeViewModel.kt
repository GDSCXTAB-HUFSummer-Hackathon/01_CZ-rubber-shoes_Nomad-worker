package com.comjeong.nomadworker.ui.home

import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.data.model.home.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult.Category
import com.comjeong.nomadworker.domain.model.home.RecommendPlaceResult
import com.comjeong.nomadworker.domain.model.place.NearbyPlaceResult
import com.comjeong.nomadworker.domain.repository.home.HomeRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    init {
        getLocationCategory()
    }

    private var _latitude : Double = NomadSharedPreferences.getUserLatitude().toDouble()
    var latitude : Double = _latitude
        set(value) {
            _latitude = value
            field = value
        }

    private var _longitude : Double = NomadSharedPreferences.getUserLongitude().toDouble()
    var longitude : Double = _longitude
        set(value) {
            _longitude = value
            field = value
        }

    private var _userAddress : String = ""
    var userAddress : String = _userAddress
        set(value) {
            _userAddress = value
            field = value
        }

    private val _isUpdateLocation: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isUpdateLocation: LiveData<Boolean> = _isUpdateLocation

    private val _isPossibleUpdate: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isPossibleUpdate: LiveData<Boolean> = _isPossibleUpdate

    private val _locationCategory: MutableLiveData<List<Category>> = MutableLiveData<List<Category>>()
    val locationCategory: LiveData<List<Category>> = _locationCategory

    private val _nearbyPlaceList: MutableLiveData<List<NearbyPlaceResult.Result>> = MutableLiveData<List<NearbyPlaceResult.Result>>()
    val nearbyPlaceResult: LiveData<List<NearbyPlaceResult.Result>> = _nearbyPlaceList

    private val _recommendPlaceList: MutableLiveData<List<RecommendPlaceResult.Result>> = MutableLiveData<List<RecommendPlaceResult.Result>>()
    val recommendPlaceList: LiveData<List<RecommendPlaceResult.Result>> = _recommendPlaceList

    private val _openPlaceDetailEvent: MutableLiveData<Event<Long>> = MutableLiveData<Event<Long>>()
    val openPlaceDetailEvent: LiveData<Event<Long>> = _openPlaceDetailEvent

    private val _openPlaceRegionEvent: MutableLiveData<Event<String>> = MutableLiveData<Event<String>>()
    val openPlaceRegionEvent: LiveData<Event<String>> = _openPlaceRegionEvent

    fun setUserLocationAddress(geocoder : Geocoder){
        try{
            val address : List<Address> = geocoder.getFromLocation(_latitude,_longitude,1)
            if(address.isNotEmpty()){
                _userAddress = address[0].getAddressLine(0)
                userAddress = _userAddress
                _isPossibleUpdate.value = true
            }
            else{
                _isPossibleUpdate.value = false
            }
        }catch (e : Throwable){
            e.printStackTrace()
        }

    }

    private fun getLocationCategory() {
        viewModelScope.launch {
            try {
                val response = repository.getLocationCategory()

                when(response.status) {
                    200 -> {
                        _locationCategory.value = response.data
                    }
                    400 -> {
                        _locationCategory.value = emptyList()
                    }
                }
                Timber.d("SUCCESS $response")
            } catch (e: Throwable) {
                Timber.d("FAILED $e")
            }
        }
    }

    fun updateUserCurrentLocation() {
        val requestBody = UpdateCurrentLocationRequestData(_latitude.toFloat(), _longitude.toFloat())
        Timber.d("$requestBody")

        viewModelScope.launch {
            try{
                val response = repository.updateCurrentLocation(requestBody)

                when(response.status) {
                    200 -> {
                        NomadSharedPreferences.setLocation(_latitude.toFloat(),_longitude.toFloat(),_userAddress)
                        _isUpdateLocation.value = true
                    }

                    else -> {
                        _isUpdateLocation.value = false
                    }
                }

                Timber.d("SUCCESS $response")
            }catch (e : Throwable){
                Timber.d("FAILED $e")
            }
        }
    }

    fun getNearbyPlace() {
        val latitude = NomadSharedPreferences.getUserLatitude()
        val longitude = NomadSharedPreferences.getUserLongitude()

        viewModelScope.launch {
            try {
                val response = repository.getNearbyPlace(latitude, longitude)

                when (response.status) {
                    200 -> {
                        _nearbyPlaceList.value = response.data
                    }
                    400 -> {
                        _nearbyPlaceList.value = response.data
                    }
                }
                Timber.d("SUCCESS $response")
            } catch (e: Throwable) {
                Timber.d("FAILED $e")
            }
        }
    }

    fun getRecommendPlace() {
        viewModelScope.launch {
            try {
                val response = repository.getRecommendPlace()

                when (response.status) {
                    200 -> {
                        _recommendPlaceList.value = response.data
                    }
                    400 -> {
                        _recommendPlaceList.value = emptyList()
                    }
                }
                Timber.d("SUCCESS $response")
            } catch (e: Throwable) {
                Timber.d("FAILED $e")
            }
        }
    }

    fun openPlaceDetailByPlaceId(placeId: Long) {
        _openPlaceDetailEvent.value = Event(placeId)
    }

    fun openPlaceRegionByLocationName(locationName: String) {
        Timber.d("CLICKED")
        _openPlaceRegionEvent.value = Event(locationName)
    }
}