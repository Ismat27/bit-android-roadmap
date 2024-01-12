package com.alat.roadmap.utils

sealed class RequestStatus<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : RequestStatus<T>(data)
    class Error<T>(message: String) : RequestStatus<T>(message = message)
    class Loading<T> : RequestStatus<T>()
    class Uninitialized<T> : RequestStatus<T>()
}
