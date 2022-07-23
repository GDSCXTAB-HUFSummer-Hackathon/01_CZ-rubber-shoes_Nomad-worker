package com.comjeong.nomadworker.ui.place

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemSearchPlaceBinding
import com.comjeong.nomadworker.domain.model.home.LocationPlaceResult

class PlaceRegionAdapter(private val viewModel: PlaceRegionViewModel)
    : ListAdapter<LocationPlaceResult.Result.Place, PlaceRegionAdapter.PlaceRegionViewHolder>(PlaceRegionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceRegionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchPlaceBinding.inflate(layoutInflater, parent, false)
        return PlaceRegionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceRegionViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class PlaceRegionViewHolder(private val binding: ItemSearchPlaceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(place: LocationPlaceResult.Result.Place) {

            binding.place = place
            binding.executePendingBindings()

        }
    }

    class PlaceRegionDiffCallback() : DiffUtil.ItemCallback<LocationPlaceResult.Result.Place>() {
        override fun areItemsTheSame(
            oldItem: LocationPlaceResult.Result.Place,
            newItem: LocationPlaceResult.Result.Place
        ): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(
            oldItem: LocationPlaceResult.Result.Place,
            newItem: LocationPlaceResult.Result.Place
        ): Boolean {
            return oldItem == newItem
        }
    }
}