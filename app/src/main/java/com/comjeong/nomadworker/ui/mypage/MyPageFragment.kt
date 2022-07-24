package com.comjeong.nomadworker.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.FEED_ID_KEY
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.databinding.FragmentMyPageBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateWithBundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private val viewModel: MyPageViewModel by sharedViewModel()

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
        observeFeedDetailEvent()


        binding.btnMypageSetting.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun observeFeedDetailEvent() {
        viewModel.openFeedDetailEvent.observe(viewLifecycleOwner, EventObserver<Long> { feedId ->
            moveFeedDetail(feedId)
        })
    }

    private fun moveFeedDetail(feedId: Long) {
        navigateWithBundle(R.id.action_my_page_to_feed_detail, bundleOf(
            FEED_ID_KEY to feedId
        ))
    }

    private fun setUserFeed() {
        binding.rvUserFeed.adapter = UserFeedAdapter(viewModel).apply {
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