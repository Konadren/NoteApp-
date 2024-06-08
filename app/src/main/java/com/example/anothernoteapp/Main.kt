package com.example.anothernoteapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.anothernoteapp.feature_note.presentation.notes.NotesViewModel
import com.example.anothernoteapp.navigation.MainNavGraph

@Composable
fun Main(
    navController: NavHostController = rememberNavController(),
    authNavController: NavController,
    notesViewModel: NotesViewModel,
    addEditNoteViewModel: AddEditNoteViewModel
){
    Scaffold {padding ->
        MainNavGraph(
            navController = navController,
            padding = padding,
            authNavController = authNavController,
            notesViewModel = notesViewModel,
            addEditNoteViewModel = addEditNoteViewModel
        )
    }
}