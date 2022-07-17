package com.comjeong.nomadworker.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentSearchOptionBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.comjeong.nomadworker.ui.common.NavigationUtil.popBackStack

class SearchOptionFragment : BaseFragment<FragmentSearchOptionBinding>(R.layout.fragment_search_option) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        binding.tbSearchOption.setNavigationOnClickListener {
            navigateUp()
        }

        binding.btnComplete.setOnClickListener {
            Toast.makeText(requireContext(), "CHECK", Toast.LENGTH_SHORT).show()
            popBackStack()
        }
    }
}