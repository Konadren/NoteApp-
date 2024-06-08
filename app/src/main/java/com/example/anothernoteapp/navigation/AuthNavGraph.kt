package com.example.anothernoteapp.navigation

import com.example.anothernoteapp.feature_note.presentation.login.LoginViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.anothernoteapp.feature_note.presentation.login.LoginScreen
import com.example.anothernoteapp.feature_note.presentation.login.SignUpScreen
import com.example.anothernoteapp.feature_note.presentation.util.Screen


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    navigation(
        startDestination = Screen.LoginScreen.route,
        route = Graph.AUTHENTICATION
    ){
        // composable 1
        composable(
            route = Screen.LoginScreen.route
        ){
            LoginScreen(onNavToHomePage = {
                navController.navigate(Graph.MAIN){
                    launchSingleTop = true
                    popUpTo(route = "SignIn"){
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ) {
                navController.navigate(Screen.RegistrationScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true
                    }

                }
            }
        }
        // composable 2
        composable(route = Screen.RegistrationScreen.route){
            SignUpScreen(onNavToHomePage = {
                navController.navigate(Graph.MAIN){
                    launchSingleTop = true
                }
            },

                loginViewModel = loginViewModel,
                onNavToLoginPage = {
                    navController.navigate(Screen.LoginScreen.route){
                        popUpTo(Screen.RegistrationScreen.route){
                            inclusive = true
                        }
                    }
                })
        }
    }

}