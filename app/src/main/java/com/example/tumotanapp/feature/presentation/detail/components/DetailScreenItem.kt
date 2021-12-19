package com.example.tumotanapp.feature.presentation.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.R
import com.example.tumotanapp.feature.presentation.detail.DetailViewModel
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.ui.theme.BackgroundBlack
import com.example.tumotanapp.ui.theme.BackgroundWhite

@ExperimentalFoundationApi
@Composable
fun DetailScreenItemFun(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
){
    val roomDetail = viewModel.detailState.value.room

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(BackgroundBlack),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            roomDetail.forEach {
                Text(
                    text = it.roomName,
                    color = BackgroundWhite
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(1),
            contentPadding = PaddingValues(10.dp)
        ){
            items(roomDetail.size){ index ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .size(200.dp, 350.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = BackgroundWhite
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Image",
                            modifier = Modifier
                                .size(250.dp)
                                .padding(10.dp)
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            roomDetail.forEach {
                                Text(text = it.roomName)
                            }
                            roomDetail.forEach {
                                RowButton(roomId = it.roomId,levelList = it.roomLevelId,navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowButton(
    roomId: Int,
    levelList: List<Int>,
    navController: NavController
){

    levelList.forEach { roomLevel ->

        Spacer(modifier = Modifier.width(20.dp))

        Button(
            onClick = {
                navController.navigate(Screen.StudyScreen.route + "/${roomId}" + "/${roomLevel}")
            },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "${roomLevel - roomId}",color = BackgroundWhite)
        }
    }
}