package com.example.tumotanapp.feature.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.tumotanapp.feature.presentation.home.HomeScreenViewModel

@Composable
fun HomeScreenFun(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionCaller(navController = navController)
    }
}

@ExperimentalCoilApi
@Composable
fun SectionCaller(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
){
    val state = viewModel.roomState.value

    if (state.isLoading) {

        Spacer(modifier = Modifier.height(300.dp))
        CircularProgressIndicator()

    } else {

        Spacer(modifier = Modifier.height(40.dp))
        HomeScreen(navController = navController)

    }
}