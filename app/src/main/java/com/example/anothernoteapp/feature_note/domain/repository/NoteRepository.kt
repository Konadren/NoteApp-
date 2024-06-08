package com.example.anothernoteapp.feature_note.domain.repository

import com.example.anothernoteapp.feature_note.domain.model.Note
import com.example.anothernoteapp.feature_note.domain.model.NoteFirestore
import com.example.anothernoteapp.feature_note.domain.repository.util.ResourcesNotes
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

//    suspend fun getNoteById(id: Int): Note?
    suspend fun getNoteById(id: Long): Flow<Note>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(id: Long)

    suspend fun updateNote(note: Note)

    fun getBookMarkedNotes(): Flow<List<Note>>



    // FIREBASE
    suspend fun getUserNotesFirestore(userId: String): Flow<ResourcesNotes<List<NoteFirestore>>>

    suspend fun getNoteFirestore(
        documentId: String,
        onError: (Throwable?) -> Unit,
        onSuccess: (NoteFirestore) -> Unit
    )

    suspend fun addNoteFirestore(
        userId: String,
        title: String,
        content: String,
        timestamp: Timestamp,
        color: Int,
        isBookmarked: Boolean,
        onComplete: (Boolean) -> Unit
    )

    suspend fun deleteNoteFirestore(
        noteId: String,
        onComplete: (Boolean) -> Unit
    )

    suspend fun updateNoteFirestore(
        noteId: String,
        title: String,
        content: String,
        onResult: (Boolean) -> Unit
    )

    fun signOut()



}
