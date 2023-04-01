package com.myapplication.execiseprojecttest.data.api

import com.myapplication.execiseprojecttest.data.api.models.Execises
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/getexecises")
    suspend fun getAllexecises(): Response<Execises>
}