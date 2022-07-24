package com.comjeong.nomadworker.ui.search

import android.os.Bundle
import android.view.View
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentSearchBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
//        binding.clSearchOption.setOnClickListener {
//            navigate(R.id.action_search_to_search_option)
//        }
//        binding.tbSearch.setOnClickListener {
//            navigate(R.id.action_search_to_place_detail)
//        }
    }
}