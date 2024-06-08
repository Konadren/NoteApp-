package com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases

data class FirestoreUseCases(
    val addNoteFirestore: AddNoteFirestore,
    val deleteNoteFirestore: DeleteNoteFirestore,
    val getNoteFirestore: GetNoteFirestore,
    val getUserNotes: GetUserNotes,
    val signOutFirestore: SignOutFirestore,
    val updateNoteFirestore: UpdateNoteFirestore
)