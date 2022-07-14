package com.comjeong.nomadworker.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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

        setNavigation()
    }

    private fun setNavigation() {
        binding.btnComplete.setOnClickListener {
            Toast.makeText(requireContext(), "COMPLETE", Toast.LENGTH_SHORT).show()
        }

        binding.tbSignUp.setNavigationOnClickListener {
            popBackStack()
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
}
