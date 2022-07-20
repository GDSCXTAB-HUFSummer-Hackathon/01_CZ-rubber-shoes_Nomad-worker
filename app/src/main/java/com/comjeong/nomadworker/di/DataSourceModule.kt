package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.data.datasource.remote.signin.SignInRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.signup.SignUpRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.source.SignInDataSource
import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<SignUpDataSource> { SignUpRemoteDataSourceImpl(get()) }
    single<SignInDataSource> { SignInRemoteDataSourceImpl(get()) }
}