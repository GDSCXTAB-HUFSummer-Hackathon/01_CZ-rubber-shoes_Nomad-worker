package com.comjeong.nomadworker.data.repository

import com.comjeong.nomadworker.data.datasource.source.SignUpDataSource
import com.comjeong.nomadworker.data.mapper.SignUpMapper
import com.comjeong.nomadworker.data.model.signup.SignUpRequestData
import com.comjeong.nomadworker.domain.SignUpRepository
import com.comjeong.nomadworker.domain.model.SignUpResult
import com.comjeong.nomadworker.domain.model.UserEmailResult
import com.comjeong.nomadworker.domain.model.UserNicknameResult

class SignUpRepositoryImpl(private val dataSource: SignUpDataSource) : SignUpRepository {
    override suspend fun postSignUp(body: SignUpRequestData): SignUpResult {
        return SignUpMapper.mapToSignUpResult(dataSource.postSignUp(body))
    }

    override suspend fun getUserEmailVerify(email: String): UserEmailResult {
        return SignUpMapper.mapToUserEmailResult(dataSource.getUserEmailVerify(email))
    }

    override suspend fun getUserNicknameVerify(nickname: String): UserNicknameResult {
        return SignUpMapper.mapToUserNicknameResult(dataSource.getUserNicknameVerify(nickname))
    }
}