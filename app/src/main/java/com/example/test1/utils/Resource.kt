package com.example.test1.utils

sealed class Resource {
    data class Success(val data: Any?) : Resource()
    data class Error(val message: String) : Resource()
    object Loading : Resource()
}