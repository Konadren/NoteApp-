package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.model.NoteFirestore
import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteFirestore @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        documentId: String,
        onError: (Throwable?) -> Unit,
        onSuccess: (NoteFirestore) -> Unit
    ) = repository.getNoteFirestore(
        documentId, onError, onSuccess
    )
}