package com.myapplication.execiseprojecttest.data.repository

import com.myapplication.data.utils.BaseApiResponse
import com.myapplication.data.utils.NetworkResult
import com.myapplication.execiseprojecttest.data.api.RemoteDataSource
import com.myapplication.execiseprojecttest.data.api.models.Execises
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): BaseApiResponse(){
    suspend fun getAllexecises():NetworkResult<Execises>{
        return safeApiCall { remoteDataSource.getAllexecises() }
    }
}