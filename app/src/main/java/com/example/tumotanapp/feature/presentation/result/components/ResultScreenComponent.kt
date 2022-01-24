package com.example.tumotanapp.feature.presentation.result.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.feature.presentation.result.ResultScreenViewModel

@ExperimentalFoundationApi
@Composable
fun ResultScreenComponent(
    viewModel: ResultScreenViewModel = hiltViewModel(),
    navController: NavController
){

    val scrollState = rememberLazyListState()

    val acceptedList = viewModel.resultState.value.acceptedList
    val rejectedList = viewModel.resultState.value.rejectedList

    Box {
        
        WordResultListItem(scrollState = scrollState, acceptedWordList = acceptedList, rejectedWordList = rejectedList)
        ResultScreenToolBar(scrollState = scrollState, navController = navController)
    }
}

