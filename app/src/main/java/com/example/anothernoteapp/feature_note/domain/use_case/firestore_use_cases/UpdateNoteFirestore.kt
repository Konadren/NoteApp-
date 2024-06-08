package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteFirestore @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        noteId: String,
        title: String,
        content: String,
        onResult: (Boolean) -> Unit
    ) = repository.updateNoteFirestore(
        noteId,
        title,
        content,
        onResult
    )
}