package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteFirestore @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        noteId: String,
        onComplete: (Boolean) -> Unit
    ) = repository.deleteNoteFirestore(noteId, onComplete)
}