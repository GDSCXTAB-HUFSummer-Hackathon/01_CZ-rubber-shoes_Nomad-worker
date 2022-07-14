package com.comjeong.nomadworker.ui.common

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

object NavigationUtil {

    fun View.navigate(action: Int) {
        Navigation.findNavController(this).navigate(action)
    }

    fun View.navigateWithData(navDirection: NavDirections) {
        Navigation.findNavController(this).navigate(navDirection)
    }

    fun Fragment.navigate(action: Int) {
        this.findNavController().navigate(action)
    }

    fun Fragment.navigateWithData(navDirections: NavDirections) {
        this.findNavController().navigate(navDirections)
    }

    fun Fragment.navigateUp() {
        findNavController().navigateUp()
    }

    fun Fragment.popBackStack() {
        findNavController().popBackStack()
    }
}