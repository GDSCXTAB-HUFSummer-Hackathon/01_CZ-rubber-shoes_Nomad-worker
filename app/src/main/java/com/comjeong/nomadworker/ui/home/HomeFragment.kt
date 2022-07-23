package com.comjeong.nomadworker.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.viewModels
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.databinding.FragmentHomeBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.ViewModelFactory

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setHomeCategoryBanner()
    }

    private fun bindViews() {
        binding.clCurrentLocation.setOnClickListener {
            openLocationDialog()
        }

        binding.nickname = NomadSharedPreferences.getUserNickName()
    }

    private fun openLocationDialog() {
        val currentLocationDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_current_location, null)
        val builder = AlertDialog.Builder(requireContext())
            .setView(currentLocationDialogView)
            .setTitle("현재 위치를 선택해주세요")

        val currentLocationDialog = builder.show()

        val setLocationButton = currentLocationDialogView.findViewById<AppCompatButton>(R.id.btn_current_location)
        setLocationButton.setOnClickListener {
            Toast.makeText(requireContext(), "위치가 변경되었습니다.", Toast.LENGTH_SHORT).show()
            currentLocationDialog.dismiss()
        }
    }

    private fun setHomeCategoryBanner() {
        with(binding.vpCategory) {
            adapter = HomeCategoryAdapter().apply {
                viewModel.homeCategory.observe(viewLifecycleOwner) { category ->
                    submitList(category)
                }
            }

            val screenWidth = resources.displayMetrics.widthPixels // 스크린 가로 길이
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width) // 페이지 전체 크기
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin) // 페이지 마진 사이즈

            val offset = screenWidth - pageWidth - pageMargin

            offscreenPageLimit = 4
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
        }
    }

}