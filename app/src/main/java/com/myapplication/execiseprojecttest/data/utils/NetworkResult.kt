package com.myapplication.data.utils

sealed class NetworkResult<T>(
    val data:T? = null,
    val message:String? = null
) {
    class Succes<T>(data: T?):NetworkResult<T>(data)
    class Error<T>(data: T?,message: String?):NetworkResult<T>(data, message)
    class Loading<T>():NetworkResult<T>()
}