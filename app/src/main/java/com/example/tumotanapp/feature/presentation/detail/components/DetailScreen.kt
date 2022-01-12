package com.example.tumotanapp.feature.presentation.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.presentation.detail.DetailViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun DetailScreenFun(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
){
    val state = viewModel.detailState.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        if (state.isLoading) {

            Spacer(modifier = Modifier.height(300.dp))
            CircularProgressIndicator()

        } else {

            state.room.forEach { roomDetail ->
                DetailSection(roomDetail = roomDetail, navController = navController)
            }

        }

    }
}