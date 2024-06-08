package com.example.anothernoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anothernoteapp.ui.theme.BabyBlue
import com.example.anothernoteapp.ui.theme.LightGreen
import com.example.anothernoteapp.ui.theme.RedOrange
import com.example.anothernoteapp.ui.theme.RedPink
import com.example.anothernoteapp.ui.theme.Violet

@Entity
data class Note(
    @PrimaryKey (autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val isBookMarked: Boolean = false
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
