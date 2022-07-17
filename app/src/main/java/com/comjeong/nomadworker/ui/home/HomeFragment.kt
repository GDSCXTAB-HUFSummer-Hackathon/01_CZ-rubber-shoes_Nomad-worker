package com.comjeong.nomadworker.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.FragmentHomeBinding
import com.comjeong.nomadworker.ui.common.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        binding.clCurrentLocation.setOnClickListener {
            openLocationDialog()
        }
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

}