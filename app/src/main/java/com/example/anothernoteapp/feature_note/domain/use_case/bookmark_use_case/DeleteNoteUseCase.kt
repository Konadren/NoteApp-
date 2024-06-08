package com.example.anothernoteapp.feature_note.domain.use_case.bookmark_use_case

import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id:Long) = repository.deleteNote(id)
}