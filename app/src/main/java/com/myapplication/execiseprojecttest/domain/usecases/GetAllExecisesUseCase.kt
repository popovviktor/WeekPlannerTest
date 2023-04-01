package com.myapplication.execiseprojecttest.domain.usecases

import com.myapplication.execiseprojecttest.data.repository.RepositoryImpl
import javax.inject.Inject

class GetAllExecisesUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke() = repositoryImpl.getAllexecises()
}