package com.example.tumotanapp.feature.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.presentation.detail.DetailViewModel
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.ui.theme.BackgroundWhite

@ExperimentalCoilApi
@Composable
fun DetailSection(
    roomDetail: RoomDetail,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
){
    val state = viewModel.detailState.value

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 15.dp)
                .size(30.dp)
                .clickable {
                    navController.navigate(Screen.HomeScreen.route)
                }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(100.dp, 170.dp),
                shape = RoundedCornerShape(10.dp),
            ) {
                Column{

                    Text(
                        text = roomDetail.roomName,
                        color = BackgroundWhite,
                        modifier = Modifier.padding(10.dp)
                    )

                    Spacer(modifier = Modifier.height(60.dp))

                    state.room.forEach { roomDetail ->
                        Image(
                            modifier = Modifier.padding(start = 35.dp).size(55.dp),
                            painter = rememberImagePainter(
                                data = roomDetail.roomImage
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                    }

                }
            }
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = roomDetail.roomName,
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 150.dp)
        ) {
            state.room.forEach{ roomDetail ->
                CustomCircleShapeButton(
                    roomId = roomDetail.roomId,
                    navController = navController,
                    levelList = roomDetail.roomLevelId
                )
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        DetailBottomSectionContent(navController = navController)
    }
}

@Composable
fun CustomCircleShapeButton(
    roomId: Int,
    navController: NavController,
    levelList: List<Int>
){

    levelList.forEach { roomLevel ->

        Spacer(modifier = Modifier.width(25.dp))
        Button(
            onClick = {
                navController.navigate(Screen.StudyScreen.route + "/${roomId}" + "/${roomLevel}")
            },
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  BackgroundWhite),
            modifier = Modifier.size(45.dp),
            shape = CircleShape
        ) {
            Text(
                text = "${roomLevel - roomId}",
                color = BackgroundWhite,
                fontSize = 17.sp
            )
        }
    }
}