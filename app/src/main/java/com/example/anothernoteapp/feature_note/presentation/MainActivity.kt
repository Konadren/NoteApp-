package com.example.anothernoteapp.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.anothernoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.anothernoteapp.feature_note.presentation.login.LoginViewModel
import com.example.anothernoteapp.feature_note.presentation.notes.NotesScreen
import com.example.anothernoteapp.feature_note.presentation.notes.NotesViewModel
import com.example.anothernoteapp.feature_note.presentation.util.Screen
import com.example.anothernoteapp.navigation.RootNavigationGraph
import com.example.anothernoteapp.ui.theme.AnotherNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            val notesViewModel = viewModel(modelClass = NotesViewModel::class.java)
            val addEditNoteViewModel = viewModel(modelClass = AddEditNoteViewModel::class.java)
            val navController: NavHostController = rememberNavController()

            AnotherNoteAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    RootNavigationGraph(
                        navController = navController,
                        loginViewModel = loginViewModel,
                        notesViewModel = notesViewModel,
                        addEditNoteViewModel = addEditNoteViewModel
                    )
                }
            }
        }
    }
}

