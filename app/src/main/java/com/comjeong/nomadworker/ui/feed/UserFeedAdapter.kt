package com.comjeong.nomadworker.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemMypageUserFeedBinding
import com.comjeong.nomadworker.domain.model.feed.UserTotalFeedResult

class UserFeedAdapter : ListAdapter<UserTotalFeedResult.Result.Feed, UserFeedAdapter.UserFeedViewHolder>(UserFeedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMypageUserFeedBinding.inflate(layoutInflater, parent, false)
        return UserFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserFeedViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class UserFeedViewHolder(private val binding: ItemMypageUserFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(feed: UserTotalFeedResult.Result.Feed) {
            binding.userFeed = feed
            binding.executePendingBindings()
        }
    }

    class UserFeedDiffCallback() : DiffUtil.ItemCallback<UserTotalFeedResult.Result.Feed>() {
        override fun areItemsTheSame(
            oldItem: UserTotalFeedResult.Result.Feed,
            newItem: UserTotalFeedResult.Result.Feed
        ): Boolean {
            return oldItem.feedId == newItem.feedId
        }

        override fun areContentsTheSame(
            oldItem: UserTotalFeedResult.Result.Feed,
            newItem: UserTotalFeedResult.Result.Feed
        ): Boolean {
            return oldItem == newItem
        }
    }
}