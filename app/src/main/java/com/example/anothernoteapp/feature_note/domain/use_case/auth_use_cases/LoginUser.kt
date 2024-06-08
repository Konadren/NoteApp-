package com.example.anothernoteapp.feature_note.domain.use_case.auth_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.AuthRepository

class LoginUser(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ){
        repository.loginUser(email, password, onComplete)
    }
}