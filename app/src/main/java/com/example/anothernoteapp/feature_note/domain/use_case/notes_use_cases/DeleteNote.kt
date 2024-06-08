package com.example.anothernoteapp.feature_note.domain.use_case.notes_use_cases

import com.example.anothernoteapp.feature_note.domain.model.Note
import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Long){
        repository.deleteNote(id)
    }
}