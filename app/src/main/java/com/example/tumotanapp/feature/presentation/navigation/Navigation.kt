package com.example.tumotanapp.feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tumotanapp.feature.presentation.splash.SplashScreenFun

@Composable
fun NavigationFun(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(route = Screen.SplashScreen.route){
            SplashScreenFun(navController = navController)
        }
        composable(route = Screen.HomeScreen.route){

        }
        composable(route = Screen.DetailScreen.route){

        }
        composable(route = Screen.StudyScreen.route){

        }
        composable(route = Screen.ResultScreen.route){

        }
    }
}