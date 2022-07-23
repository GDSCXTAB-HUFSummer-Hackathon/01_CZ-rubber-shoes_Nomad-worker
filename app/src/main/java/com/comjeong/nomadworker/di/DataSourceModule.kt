package com.comjeong.nomadworker.di

import com.comjeong.nomadworker.data.datasource.remote.home.HomeRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.place.PlaceRegionRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.signin.SignInRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.remote.signup.SignUpRemoteDataSourceImpl
import com.comjeong.nomadworker.data.datasource.source.SignInDataSource
import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import com.comjeong.nomadworker.data.datasource.source.home.HomeRemoteDataSource
import com.comjeong.nomadworker.data.datasource.source.place.PlaceRegionRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<SignUpDataSource> { SignUpRemoteDataSourceImpl(get()) }
    single<SignInDataSource> { SignInRemoteDataSourceImpl(get()) }
    single<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
    single<PlaceRegionRemoteDataSource> { PlaceRegionRemoteDataSourceImpl(get()) }
}