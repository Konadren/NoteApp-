package com.example.anothernoteapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.anothernoteapp.feature_note.presentation.notes.NotesScreen
import com.example.anothernoteapp.feature_note.presentation.notes.NotesViewModel
import com.example.anothernoteapp.feature_note.presentation.util.Screen


@Composable
fun MainNavGraph(
    navController: NavHostController,
    padding: PaddingValues,
    authNavController: NavController,
    notesViewModel: NotesViewModel,
    addEditNoteViewModel: AddEditNoteViewModel
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = Screen.NotesScreen.route
    ){
        composable(route = Screen.NotesScreen.route){
            NotesScreen(navController = navController)
        }
        composable(
            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ){
                    type = NavType.LongType
                    defaultValue = -1
                },
                navArgument(
                    name = "noteColor"
                ){
                    type = NavType.IntType
                    defaultValue = -1
                },
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                navController = navController,
                noteColor = color
            )
        }
    }

}