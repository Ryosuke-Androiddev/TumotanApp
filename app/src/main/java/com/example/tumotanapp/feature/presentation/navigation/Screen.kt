package com.example.tumotanapp.feature.presentation.navigation

import android.annotation.SuppressLint
import com.example.tumotanapp.feature.presentation.util.PresentationConstants

sealed class Screen(val route: String){

    @SuppressLint("CustomSplashScreen")
    object SplashScreen: Screen(PresentationConstants.SPLASH_SCREEN_ROUTE)
    object HomeScreen: Screen(PresentationConstants.HOME_SCREEN_ROUTE)
    object DetailScreen: Screen(PresentationConstants.DETAIL_SCREEN_ROUTE)
    object StudyScreen: Screen(PresentationConstants.STUDY_SCREEN_ROUTE)
    object ResultScreen: Screen(PresentationConstants.RESULT_SCREEN_ROUTE)

}
