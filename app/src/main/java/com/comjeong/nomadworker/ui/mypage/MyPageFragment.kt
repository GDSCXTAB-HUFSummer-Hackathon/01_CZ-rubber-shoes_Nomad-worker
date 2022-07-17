package com.comjeong.nomadworker.ui.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentMyPageBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMypageSetting.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog(){
        val bottomSheet = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialog)
        bottomSheet.setContentView(R.layout.fragment_my_page_setting_bottom_sheet)
        bottomSheet.show()
    }

}