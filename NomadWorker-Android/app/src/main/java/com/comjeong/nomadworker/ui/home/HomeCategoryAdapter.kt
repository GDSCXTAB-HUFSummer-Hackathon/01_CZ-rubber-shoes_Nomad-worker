package com.comjeong.nomadworker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comjeong.nomadworker.databinding.ItemHomeCategoryBinding
import com.comjeong.nomadworker.domain.model.home.LocationCategoryResult.Category

class HomeCategoryAdapter(private val viewModel: HomeViewModel) : ListAdapter<Category, HomeCategoryAdapter.HomeCategoryViewHolder>(HomeCategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeCategoryBinding.inflate(layoutInflater, parent, false)
        return HomeCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    inner class HomeCategoryViewHolder(private val binding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(category: Category) {
            binding.viewModel = viewModel
            binding.category = category
            binding.executePendingBindings()
        }
    }

    class HomeCategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }
}