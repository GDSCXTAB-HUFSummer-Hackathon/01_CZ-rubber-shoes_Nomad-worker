package com.comjeong.nomadworker.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentSignUpNickNameBinding
import com.comjeong.nomadworker.ui.common.BaseFragment
import com.comjeong.nomadworker.ui.common.DialogUtil.setSignUpCloseDialog
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigate
import com.comjeong.nomadworker.ui.common.NavigationUtil.navigateUp
import com.comjeong.nomadworker.ui.common.NavigationUtil.popBackStack
import com.google.android.material.snackbar.Snackbar

class SignUpNickNameFragment :
    BaseFragment<FragmentSignUpNickNameBinding>(R.layout.fragment_sign_up_nick_name) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setNavigation()
    }

    private fun bindViews() {
        binding.etNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!isExistingNickName()) {
                    handleNextButton(true)
                    moveNextStep()
                } else {
                    handleNextButton(false)
                }
            }
        })
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

    private fun handleNextButton(canEnable: Boolean) {
        if (canEnable) {
            binding.btnComplete.isEnabled = true
            binding.btnComplete.setBackgroundResource(R.drawable.bg_blue_radius_10)
        } else {
            binding.btnComplete.isEnabled = false
            binding.btnComplete.setBackgroundResource(R.drawable.bg_grey06_radius_10)
        }
    }

    private fun moveNextStep() {
        binding.btnComplete.setOnClickListener {
            // TODO Navigate Onboarding
            Toast.makeText(requireContext(), "회원가입 완료", Toast.LENGTH_SHORT).show()
        }
    }
}
