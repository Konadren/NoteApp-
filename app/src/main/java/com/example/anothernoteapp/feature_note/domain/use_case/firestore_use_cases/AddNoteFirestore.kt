package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import com.google.firebase.Timestamp
import javax.inject.Inject

class AddNoteFirestore @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        userId: String, title: String, content: String, timestamp: Timestamp,
        color: Int, isBookmarked: Boolean,
        onComplete:(Boolean) -> Unit) = repository.addNoteFirestore(userId, title, content, timestamp,
        color, isBookmarked, onComplete
        )
}