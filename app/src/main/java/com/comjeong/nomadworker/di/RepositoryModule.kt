package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.data.repository.SignUpRepositoryImpl
import com.comjeong.nomadworker.domain.SignUpRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SignUpRepository> { SignUpRepositoryImpl(get()) }
}