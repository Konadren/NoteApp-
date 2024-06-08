package com.example.anothernoteapp.feature_note.data.repository

import com.example.anothernoteapp.feature_note.data.data_source.NoteDao
import com.example.anothernoteapp.feature_note.domain.model.Note
import com.example.anothernoteapp.feature_note.domain.model.NoteFirestore
import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import com.example.anothernoteapp.feature_note.domain.repository.util.ResourcesNotes
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.auth
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor (
    private val dao: NoteDao
): NoteRepository {
    // ROOM DATABASE
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Long): Flow<Note> {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(id: Long) {
        return dao.deleteNote(id)
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note)
    }

    override fun getBookMarkedNotes(): Flow<List<Note>> {
        return dao.getBookmarkedNotes()
    }



    // FIRESTORE
    override suspend fun getUserNotesFirestore(
        userId: String)
    : Flow<ResourcesNotes<List<NoteFirestore>>>  = callbackFlow{
        var snapshotStateListener: ListenerRegistration? = null
        try {
            snapshotStateListener = Firebase.firestore.collection("notes")
                .orderBy("timestamp")
                .whereEqualTo("userId", userId)
                .addSnapshotListener{ snapshot, e ->
                    val response = if (snapshot != null) {
                        val notes = snapshot.toObjects(NoteFirestore::class.java)
                        ResourcesNotes.Success(data = notes)
                    } else {
                        ResourcesNotes.Error(throwable = e?.cause)
                    }
                    trySend(response)
                }
        } catch (e: Exception){
            trySend(ResourcesNotes.Error(e?.cause))
            e.printStackTrace()
        }
        awaitClose{
            snapshotStateListener?.remove()
        }
    }

    override suspend fun getNoteFirestore(
        documentId: String,
        onError: (Throwable?) -> Unit,
        onSuccess: (NoteFirestore) -> Unit
    ) {
        Firebase.firestore.collection("notes")
            .document(documentId)
            .get()
            .addOnSuccessListener {
                it?.toObject(NoteFirestore::class.java)?.let {it1 -> onSuccess.invoke(it1)}
            }
            .addOnFailureListener{ result ->
                onError.invoke(result.cause)
            }
    }

    override suspend fun addNoteFirestore(
        userId: String,
        title: String,
        content: String,
        timestamp: Timestamp,
        color: Int,
        isBookmarked: Boolean,
        onComplete: (Boolean) -> Unit
    ) {
        val documentId = Firebase.firestore.collection("notes").document().id
        val note = NoteFirestore(
            userId = userId,
            title = title,
            content = content,
            timestamp = timestamp,
            documentId = documentId
        )
        Firebase.firestore.collection("notes")
            .document(documentId)
            .set(note)
            .addOnCompleteListener{result ->
                onComplete.invoke(result.isSuccessful)
            }
    }

    override suspend fun deleteNoteFirestore(noteId: String, onComplete: (Boolean) -> Unit) {
        Firebase.firestore.collection("notes")
            .document(noteId)
            .delete()
            .addOnCompleteListener{
                onComplete.invoke(it.isSuccessful)
            }
    }

    override suspend fun updateNoteFirestore(
        noteId: String,
        title: String,
        content: String,
        onResult: (Boolean) -> Unit
    ) {
        val updateData = hashMapOf<String, Any>(
            "content" to content,
            "title" to title
        )

        Firebase.firestore.collection("notes")
            .document(noteId)
            .update(updateData)
            .addOnCompleteListener{
                onResult(it.isSuccessful)
            }

    }

    override fun signOut() = Firebase.auth.signOut()

}