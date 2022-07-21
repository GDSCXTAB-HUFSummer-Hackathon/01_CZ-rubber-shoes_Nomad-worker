package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.data.repository.signin.SignInRepositoryImpl
import com.comjeong.nomadworker.data.repository.signup.SignUpRepositoryImpl
import com.comjeong.nomadworker.domain.repository.signin.SignInRepository
import com.comjeong.nomadworker.domain.repository.signup.SignUpRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SignUpRepository> { SignUpRepositoryImpl(get()) }
    single<SignInRepository> { SignInRepositoryImpl(get()) }
}