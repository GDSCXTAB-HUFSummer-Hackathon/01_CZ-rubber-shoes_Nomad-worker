package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.ui.home.UserLocationViewModel
import com.comjeong.nomadworker.ui.signin.SignInViewModel
import com.comjeong.nomadworker.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { UserLocationViewModel(get())}
}