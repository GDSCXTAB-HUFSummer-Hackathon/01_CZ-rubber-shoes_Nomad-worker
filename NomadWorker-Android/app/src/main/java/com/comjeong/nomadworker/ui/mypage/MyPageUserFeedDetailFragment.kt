package com.comjeong.nomadworker.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.FEED_ID_KEY
import com.comjeong.nomadworker.databinding.FragmentMyPageUserFeedDetailBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MyPageUserFeedDetailFragment : BaseFragment<FragmentMyPageUserFeedDetailBinding>(R.layout.fragment_my_page_user_feed_detail) {

    private val viewModel: MyPageViewModel by sharedViewModel()
    private var feedId: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        feedId = requireArguments().getLong(FEED_ID_KEY)
        viewModel.feedId = feedId

        viewModel.getUserFeedDetail()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindView()

        observeUserFeedDetail()
    }

    private fun observeUserFeedDetail() {
        viewModel.userFeedDetail.observe(viewLifecycleOwner) { feedDetail ->
            binding.feedDetail = feedDetail
        }
    }

    private fun bindView() {
        binding.tbFeedDetail.setNavigationOnClickListener {
            navigateUp()
        }
    }
}