package com.example.anothernoteapp.feature_note.presentation.util

sealed class Screen(val route: String) {
    object LoginScreen: Screen("LOGIN")
    object RegistrationScreen: Screen("SIGN_UP")
    object NotesScreen: Screen("NOTES")
    object AddEditNoteScreen: Screen("ADD_EDIT_NOTE")
}