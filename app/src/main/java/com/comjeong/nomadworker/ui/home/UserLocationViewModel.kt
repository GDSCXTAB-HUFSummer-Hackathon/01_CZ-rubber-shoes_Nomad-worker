package com.comjeong.nomadworker.ui.home

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.data.model.location.UpdateCurrentLocationRequestData
import com.comjeong.nomadworker.domain.repository.location.UserLocationRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class UserLocationViewModel(private val repository : UserLocationRepository) : ViewModel() {

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


    fun setUserLocationAddress(geocoder : Geocoder){
        val address : List<Address> = geocoder.getFromLocation(_latitude,_longitude,1)
        if(address.isNotEmpty()){
            _userAddress = address[0].getAddressLine(0)
            userAddress = _userAddress
            _isPossibleUpdate.value = true
        }
        else{
            _isPossibleUpdate.value = false
        }

    }

    fun updateUserCurrentLocation() {
        val requestBody = UpdateCurrentLocationRequestData(_latitude.toFloat(), _longitude.toFloat())
        Timber.d("$requestBody")

        viewModelScope.launch {
            try{
//                val userToken : String? = NomadSharedPreferences.getAccessToken()
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
}