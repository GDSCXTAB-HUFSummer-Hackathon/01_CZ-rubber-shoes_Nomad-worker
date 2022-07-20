package com.comjeong.nomadworker.data.repository.signin

import com.comjeong.nomadworker.data.datasource.source.SignInDataSource
import com.comjeong.nomadworker.data.mapper.SignInMapper
import com.comjeong.nomadworker.data.model.signin.SignInRequestData
import com.comjeong.nomadworker.domain.model.signin.SignInResult
import com.comjeong.nomadworker.domain.repository.signin.SignInRepository

class SignInRepositoryImpl(private val dataSource: SignInDataSource) : SignInRepository {
    override suspend fun postSignIn(body: SignInRequestData): SignInResult {
        return SignInMapper.mapToSignInResult(dataSource.postSignIn(body))
    }
}