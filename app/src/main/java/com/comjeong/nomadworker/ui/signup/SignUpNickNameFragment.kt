package com.comjeong.nomadworker.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.EventObserver
import com.comjeong.nomadworker.databinding.FragmentSignUpNickNameBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setSignUpCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.comjeong.nomadworker.ui.common.NavigationUtil.popBackStack
import com.comjeong.nomadworker.ui.common.textChangesToFlow
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class SignUpNickNameFragment :
    BaseFragment<FragmentSignUpNickNameBinding>(R.layout.fragment_sign_up_nick_name) {

    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setNavigation()
        observeDuplicateNickname()
    }

    private fun observeDuplicateNickname() {
        viewModel.isNicknameDuplicated.observe(viewLifecycleOwner, EventObserver<Boolean> { isDuplicated ->
            if (!isDuplicated) {
                // 가입하기 활성화
                Toast.makeText(requireContext(), R.string.usable_nickname, Toast.LENGTH_SHORT).show()
                handleNextButton(true)
            } else {
                Toast.makeText(requireContext(), R.string.unusable_nickname, Toast.LENGTH_SHORT).show()
                handleNextButton(false)
            }
        })
    }

    private fun setNavigation() {
        binding.tbSignUp.setNavigationOnClickListener {
            navigateUp()
        }

        binding.tbSignUp.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.close -> {
                    setSignUpCloseDialog(requireContext())
                    true
                }
                else -> false
            }
        }
    }

    private fun bindViews() {
        binding.etNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length!! > 0) {
                    binding.tvCheckNickname.visibility = View.VISIBLE
                } else {
                    binding.tvCheckNickname.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        binding.tvCheckNickname.setOnClickListener {
            checkDuplicateNickname()
        }

        binding.btnComplete.setOnClickListener {
            navigate(R.id.action_signup_to_on_boarding)
            requireActivity().finish()
        }
    }

    private fun checkDuplicateNickname() {
        val nickname = binding.etNickname.text.toString().trim()

        viewModel.checkDuplicateNickname(nickname)
    }

    /**
     * 닉네임 확인 API Call
     * 메소드 리팩토링 필요!!
     */
    private fun isExistingNickName(): Boolean {
        val inputNickName = binding.etNickname.text.toString().trim()
        val apiNickName = "AAA"
        return if (inputNickName == apiNickName) {
            binding.etNickname.setBackgroundResource(R.drawable.bg_red_radius_10)
            binding.tvStatusMessage.visibility = View.VISIBLE
            binding.tvStatusMessage.text = getString(R.string.unusable_nickname)
            binding.tvStatusMessage.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.nomad_accent_red
                )
            )
            true
        } else {
            binding.etNickname.setBackgroundResource(R.drawable.bg_green_radius_10)
            binding.tvStatusMessage.visibility = View.VISIBLE
            binding.tvStatusMessage.text = getString(R.string.usable_nickname)
            binding.tvStatusMessage.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.nomad_positive_green
                )
            )
            false
        }
    }

    private fun handleNextButton(canEnable: Boolean) {
        if (canEnable) {
            binding.btnComplete.isEnabled = true
            binding.btnComplete.setBackgroundResource(R.drawable.bg_blue_radius_10)
        } else {
            binding.btnComplete.isEnabled = false
            binding.btnComplete.setBackgroundResource(R.drawable.bg_grey06_radius_10)
        }
    }
}
