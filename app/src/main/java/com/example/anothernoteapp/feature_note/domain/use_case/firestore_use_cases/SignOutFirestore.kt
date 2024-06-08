package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class SignOutFirestore @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke() = repository.signOut()
}