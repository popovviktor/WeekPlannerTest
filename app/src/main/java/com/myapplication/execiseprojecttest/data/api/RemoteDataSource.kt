package com.myapplication.execiseprojecttest.data.api

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){
    suspend fun getAllexecises() = apiService.getAllexecises()
}