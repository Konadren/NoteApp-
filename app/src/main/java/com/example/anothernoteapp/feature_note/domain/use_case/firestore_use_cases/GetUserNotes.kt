package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class GetUserNotes @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(userId: String) = repository.getUserNotesFirestore(userId)
}