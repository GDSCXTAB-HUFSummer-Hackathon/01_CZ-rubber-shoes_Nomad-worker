package com.comjeong.nomadworker.ui.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.common.Event
import com.comjeong.nomadworker.domain.model.place.LocationPlaceResult
import com.comjeong.nomadworker.domain.repository.place.PlaceRegionRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class PlaceRegionViewModel(private val repository: PlaceRegionRepository) : ViewModel() {


    private var _locationName: String = ""
    var locationName: String = _locationName
        set(value) {
            _locationName = value
            field = value
        }

    private val _placeTag: MutableLiveData<String> = MutableLiveData<String>()
    val placeTag: LiveData<String> = _placeTag

    private val _placeList: MutableLiveData<List<LocationPlaceResult.Result.Place>> = MutableLiveData<List<LocationPlaceResult.Result.Place>>()
    val placeList: LiveData<List<LocationPlaceResult.Result.Place>> = _placeList

    private val _openPlaceDetailEvent: MutableLiveData<Event<Long>> = MutableLiveData<Event<Long>>()
    val openPlaceDetailEvent: LiveData<Event<Long>> = _openPlaceDetailEvent

    fun getPlaceWithLocationName() {
        Timber.d("START")
        viewModelScope.launch {
            try {
                Timber.d(_locationName)
                val response = repository.getPlaceByLocationName(_locationName)

                when (response.status) {
                    200 -> {
                        _placeTag.value = response.data?.locationName
                        _placeList.value = response.data?.place
                    }
                    400 -> {
                        _placeTag.value = ""
                        _placeList.value = emptyList()
                    }
                }

                Timber.d("SUCCESS : $response")
            } catch (e: Throwable) {
                Timber.d("FAILED : $e")
            }
        }
    }

    fun openPlaceDetailByPlaceId(placeId: Long) {
        _openPlaceDetailEvent.value = Event(placeId)
    }
}