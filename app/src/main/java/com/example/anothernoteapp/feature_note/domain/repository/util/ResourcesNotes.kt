package com.example.anothernoteapp.feature_note.domain.repository.util

sealed class ResourcesNotes<T>(
    val data:T? = null,
    val throwable: Throwable? = null
){
    class Loading<T>: ResourcesNotes<T>()
    class Success<T>(data: T?): ResourcesNotes<T>(data = data)
    class Error<T>(throwable: Throwable?): ResourcesNotes<T>(throwable = throwable)
}