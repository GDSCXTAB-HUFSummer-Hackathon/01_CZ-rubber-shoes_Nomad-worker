package com.comjeong.nomadworker.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.common.Constants.VERIFICATION_CODE
import com.comjeong.nomadworker.databinding.FragmentSignUpEmailBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setSignUpCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateWithBundle

class SignUpEmailFragment :
    BaseFragment<FragmentSignUpEmailBinding>(R.layout.fragment_sign_up_email) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setNavigation()
    }


    private fun setNavigation() {
        binding.tbSignUp.setNavigationOnClickListener {
            requireActivity().finish()
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
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isValidatePattern()) {
                    handleNextButton(true)
                    moveNextStep()
                } else {
                    handleNextButton(false)

                }
            }
        })
    }

    private fun handleNextButton(canEnable: Boolean) {
        if (canEnable) {
            binding.btnVerifyEmail.isEnabled = true
            binding.btnVerifyEmail.setBackgroundResource(R.drawable.bg_blue_radius_10)
        } else {
            binding.btnVerifyEmail.isEnabled = false
            binding.btnVerifyEmail.setBackgroundResource(R.drawable.bg_grey06_radius_10)
        }
    }

    private fun isValidatePattern(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val pattern = android.util.Patterns.EMAIL_ADDRESS

        return if (pattern.matcher(email).matches()) {
            binding.etEmail.setBackgroundResource(R.drawable.bg_green_radius_10)
            binding.tvStatusMessage.visibility = View.VISIBLE
            binding.tvStatusMessage.text = getString(R.string.correct_email_format)
            binding.tvStatusMessage.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.nomad_positive_green
                )
            )
            true
//        } else if (pattern.matcher(email).matches() && isExistingEmail()) {
//            binding.etEmail.setBackgroundResource(R.drawable.bg_red_radius_10)
//            binding.tvStatusMessage.visibility = View.VISIBLE
//            binding.tvStatusMessage.text = getString(R.string.already_user)
//            binding.tvStatusMessage.setTextColor(ContextCompat.getColor(requireActivity(), R.color.nomad_accent_red))
//            false
        } else {
            binding.etEmail.setBackgroundResource(R.drawable.bg_red_radius_10)
            binding.tvStatusMessage.visibility = View.VISIBLE
            binding.tvStatusMessage.text = getString(R.string.incorrect_email_format)
            binding.tvStatusMessage.setTextColor(
                ContextCompat.getColor(
                    requireActivity(),
                    R.color.nomad_accent_red
                )
            )
            false
        }
    }

    /**
     * 임시 구현
     * 유효 이메일 API 호출 필요
     * Debounce로 API 호출하면서 존재하는 Email인지 확인
     */
//    private fun isExistingEmail(): Boolean {
//        val email = binding.etEmail.text.toString().trim()
//        val sampleEmail = "test@naver.com"
//        return email == sampleEmail
//    }

    private fun moveNextStep() {
        val verificationCode = callEmailVerifyAPI()

        binding.btnVerifyEmail.setOnClickListener {
            navigateWithBundle(R.id.action_email_to_verify, bundleOf(
                VERIFICATION_CODE to verificationCode
            ))
        }
    }

    /**
     * 이메일 인증 API 호출
     * 추후에 ViewModel을 통해 구현해야 함
     */
    private fun callEmailVerifyAPI(): String {
        return "aaa"
    }
}