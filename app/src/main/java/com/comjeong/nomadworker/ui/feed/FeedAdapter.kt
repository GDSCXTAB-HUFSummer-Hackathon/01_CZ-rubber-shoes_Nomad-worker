package com.comjeong.nomadworker.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemFeedMainBinding
import com.comjeong.nomadworker.domain.model.feed.TotalFeedsResult

class FeedAdapter : ListAdapter<TotalFeedsResult.Result, FeedAdapter.FeedViewHolder>(FeedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFeedMainBinding.inflate(layoutInflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    inner class FeedViewHolder(private val binding: ItemFeedMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(feed: TotalFeedsResult.Result) {
            binding.feed = feed
            binding.executePendingBindings()
        }
    }

    class FeedDiffCallback() : DiffUtil.ItemCallback<TotalFeedsResult.Result>() {
        override fun areItemsTheSame(
            oldItem: TotalFeedsResult.Result,
            newItem: TotalFeedsResult.Result
        ): Boolean {
            return oldItem.feedId == newItem.feedId
        }

        override fun areContentsTheSame(
            oldItem: TotalFeedsResult.Result,
            newItem: TotalFeedsResult.Result
        ): Boolean {
            return oldItem == newItem
        }
    }
}
