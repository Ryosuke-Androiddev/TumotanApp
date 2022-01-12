package com.example.tumotanapp.feature.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.tumotanapp.R
import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.presentation.home.HomeScreenViewModel
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.ui.theme.*

@ExperimentalCoilApi
@Composable
fun HomeSecondSection(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController
){
    Spacer(modifier = Modifier.height(20.dp))

    DisplayTitleText(title = "TOIEC Series", navController = navController)

    LazyRow(
        contentPadding = PaddingValues(vertical = 15.dp,horizontal = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        val roomList = viewModel.roomState.value.roomList

        items(
            items = roomList,
        ){ room ->
            SimpleRoomItem(room = room, navController = navController)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun SimpleRoomItem(
    room: Room,
    navController: NavController
){
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.DetailScreen.route + "/${room.roomId}")
            }
            .size(120.dp, 200.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column{

            Text(
                text = room.roomName,
                color = BackgroundWhite,
                modifier = Modifier.padding(start = 15.dp, top = 20.dp),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(75.dp))

            Image(
                modifier = Modifier.padding(start = 50.dp).size(65.dp),
                painter = rememberImagePainter(
                    data = room.roomImage
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

        }
    }
}