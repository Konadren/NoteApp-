package com.example.anothernoteapp.feature_note.presentation.login

data class LoginState(
    val userName:String = "",
    val password:String = "",
    val userNameSingUp:String = "",
    val passwordSignUp:String = "",
    val confirmPasswordSignUp: String = "",
    val isLoading:Boolean = false,
    val isSuccessLogin:Boolean = false,
    val signUpError:String? = null,
    val loginError:String? = null
)
