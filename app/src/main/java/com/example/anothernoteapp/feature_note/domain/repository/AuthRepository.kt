package com.example.anothernoteapp.feature_note.domain.repository

import com.google.firebase.auth.AuthResult

interface AuthRepository {

    suspend fun createUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ): AuthResult

    suspend fun loginUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ): AuthResult

    fun hasUser(): Boolean
}