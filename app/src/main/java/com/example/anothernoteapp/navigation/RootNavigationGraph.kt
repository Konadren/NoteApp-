package com.example.anothernoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.anothernoteapp.Main
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.anothernoteapp.feature_note.presentation.login.LoginViewModel
import com.example.anothernoteapp.feature_note.presentation.notes.NotesViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    notesViewModel: NotesViewModel,
    addEditNoteViewModel: AddEditNoteViewModel
){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){
        authNavGraph(
            navController = navController,
            loginViewModel = loginViewModel
        )
        composable(route = Graph.MAIN){
            Main(
                authNavController = navController,
                notesViewModel = notesViewModel,
                addEditNoteViewModel = addEditNoteViewModel
            )
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN = "main_graph"
}