package com.comjeong.nomadworker.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentMyPageBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.feed.UserFeedAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private val viewModel: MyPageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getUserInfo()
        viewModel.getUserTotalFeed()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeUserInfo()
        setUserFeed()
        binding.btnMypageSetting.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun setUserFeed() {
        binding.rvUserFeed.adapter = UserFeedAdapter().apply {
            viewModel.userFeedList.observe(viewLifecycleOwner) { feedList ->
                submitList(feedList)
            }
        }
    }

    private fun observeUserInfo() {
        viewModel.userInfo.observe(viewLifecycleOwner) { userInfo ->
            binding.userInfo = userInfo
        }
    }

    private fun showBottomSheetDialog(){
        val bottomSheet = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialog)
        bottomSheet.setContentView(R.layout.fragment_my_page_setting_bottom_sheet)
        bottomSheet.show()
    }

}