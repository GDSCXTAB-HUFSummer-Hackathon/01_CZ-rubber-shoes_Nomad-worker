package com.comjeong.nomadworker.data.repository

import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import com.comjeong.nomadworker.data.mapper.SignUpMapper
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.SignUpRepository
import com.comjeong.nomadworker.domain.model.SignUpResult

class SignUpRepositoryImpl(private val dataSource: SignUpDataSource) : SignUpRepository {
    override suspend fun postSignUp(body: SignUpRequestData): SignUpResult {
        return SignUpMapper.mapToSignUpResult(dataSource.postSignUp(body))
    }
}