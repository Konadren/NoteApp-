package com.example.anothernoteapp.feature_note.domain.model


import com.example.anothernoteapp.ui.theme.BabyBlue
import com.example.anothernoteapp.ui.theme.LightGreen
import com.example.anothernoteapp.ui.theme.RedOrange
import com.example.anothernoteapp.ui.theme.RedPink
import com.example.anothernoteapp.ui.theme.Violet
import com.google.firebase.Timestamp


data class NoteFirestore(
    val userId: String = "",
    val noteId: String = "",
    val documentId: String = "",
    val title: String = "",
    val content: String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val color: Int = 0,
    val isBookMarked: Boolean = false
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
