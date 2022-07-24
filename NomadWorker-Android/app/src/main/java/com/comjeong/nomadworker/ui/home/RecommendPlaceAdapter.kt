package com.comjeong.nomadworker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemHomeRecommendBinding
import com.comjeong.nomadworker.domain.model.home.RecommendPlaceResult

class RecommendPlaceAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<RecommendPlaceResult.Result, RecommendPlaceAdapter.RecommendPlaceViewHolder>(
        RecommendPlaceDiffCallback()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendPlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeRecommendBinding.inflate(layoutInflater, parent, false)
        return RecommendPlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendPlaceViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    inner class RecommendPlaceViewHolder(private val binding: ItemHomeRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(place: RecommendPlaceResult.Result) {
            binding.viewModel = viewModel
            binding.place = place
            binding.executePendingBindings()
        }

    }

    class RecommendPlaceDiffCallback() : DiffUtil.ItemCallback<RecommendPlaceResult.Result>() {
        override fun areItemsTheSame(
            oldItem: RecommendPlaceResult.Result,
            newItem: RecommendPlaceResult.Result
        ): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(
            oldItem: RecommendPlaceResult.Result,
            newItem: RecommendPlaceResult.Result
        ): Boolean {
            return oldItem == newItem
        }
    }

}