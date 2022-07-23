package com.comjeong.nomadworker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemHomeNearbyBinding
import com.comjeong.nomadworker.domain.model.place.NearbyPlaceResult

class NearbyPlaceAdapter : ListAdapter<NearbyPlaceResult.Result, NearbyPlaceAdapter.NearbyPlaceViewHolder>(NearbyPlaceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyPlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeNearbyBinding.inflate(layoutInflater, parent, false)
        return NearbyPlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NearbyPlaceViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class NearbyPlaceViewHolder(private val binding: ItemHomeNearbyBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(placeResult: NearbyPlaceResult.Result) {
            binding.place = placeResult
            binding.executePendingBindings()
        }

    }

    class NearbyPlaceDiffCallback() : DiffUtil.ItemCallback<NearbyPlaceResult.Result>() {
        override fun areItemsTheSame(
            oldItem: NearbyPlaceResult.Result,
            newItem: NearbyPlaceResult.Result
        ): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(
            oldItem: NearbyPlaceResult.Result,
            newItem: NearbyPlaceResult.Result
        ): Boolean {
            return oldItem == newItem
        }
    }
}