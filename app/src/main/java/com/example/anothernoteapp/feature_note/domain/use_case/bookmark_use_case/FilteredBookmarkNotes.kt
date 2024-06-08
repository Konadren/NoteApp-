package com.example.anothernoteapp.feature_note.domain.use_case.bookmark_use_case

import com.example.anothernoteapp.feature_note.domain.model.Note
import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredBookmarkNotes @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getBookMarkedNotes()
    }
}