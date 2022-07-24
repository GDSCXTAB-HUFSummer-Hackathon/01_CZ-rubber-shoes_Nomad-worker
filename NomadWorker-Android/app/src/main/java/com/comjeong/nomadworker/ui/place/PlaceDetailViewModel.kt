package com.comjeong.nomadworker.ui.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comjeong.nomadworker.domain.model.place.PlaceDetailResult
import com.comjeong.nomadworker.domain.repository.place.PlaceDetailRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class PlaceDetailViewModel(private val repository: PlaceDetailRepository) : ViewModel() {

    private var _placeId: Long = 0
    var placeId: Long = _placeId
        set(value) {
            _placeId = value
            field = value
        }

    private val _placeDetailInfo: MutableLiveData<PlaceDetailResult.Result> =
        MutableLiveData<PlaceDetailResult.Result>()
    val placeDetailInfo: LiveData<PlaceDetailResult.Result> = _placeDetailInfo

    fun getPlaceDetailByPlaceId() {
        viewModelScope.launch {
            try {
                val response = repository.getPlaceDetailById(_placeId)

                when (response.status) {
                    200 -> {
                        _placeDetailInfo.value = response.data
                    }
                    400 -> {
                        _placeDetailInfo.value = response.data
                    }
                }

                Timber.d("SUCCESS: $response")
            } catch (e: Throwable) {
                Timber.d("FAILED: $e")
            }

        }

    }


}