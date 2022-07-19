package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.data.datasource.remote.SignUpRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<SignUpDataSource> { SignUpRemoteDataSourceImpl(get()) }
}