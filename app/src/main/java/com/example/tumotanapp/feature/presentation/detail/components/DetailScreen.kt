package com.example.tumotanapp.feature.presentation.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.feature.presentation.detail.DetailViewModel

@ExperimentalFoundationApi
@Composable
fun DetailScreenFun(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
){
    DetailScreenItemFun(navController = navController)
}