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
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    DisplayTitleText(
        title = "Start your activity",
        navController = navController,
        modifier = modifier,
        startPadding = 20
    )

    LazyRow(
        contentPadding = PaddingValues(vertical = 15.dp,horizontal = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        val roomList = viewModel.roomState.value.roomList

        items(
            items = roomList,
        ){ room ->
            RoomItem(room = room, navController = navController)
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    DisplayTitleText(title = "TOIEC", navController = navController, modifier, endPadding = 12)

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

//    val roomList = viewModel.roomState.value.roomList
//
//    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
//        roomList.forEach { room ->
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                shape = RoundedCornerShape(size = 10.dp),
//                color = TextBlack.copy(alpha = 0.9f)
//            ) {
//
//                Image(
//                    modifier = Modifier.size(10.dp),
//                    painter = rememberImagePainter(
//                        data = room.roomImage
//                    ),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                )
//            }
//        }
//    }
}

@ExperimentalCoilApi
@Composable
fun RoomItem(
    room: Room,
    navController: NavController
){
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.DetailScreen.route + "/${room.roomId}")
            }
            .size(340.dp, 300.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Surface(
                modifier = Modifier.size(120.dp,200.dp),
                color = ButtonBackgroundGreen
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Text(
                        text = room.roomName,
                        color = BackgroundWhite,
                        modifier = Modifier.padding( top = 25.dp, end = 20.dp),
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(75.dp))

                    Image(
                        modifier = Modifier.padding(start = 15.dp).size(65.dp),
                        painter = rememberImagePainter(
                            data = room.roomImage
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = BackgroundWhite,
                shape = RoundedCornerShape(
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    CustomCircleComponent(canvasSize = 60.dp)

                    Column{
                        Row(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            CircleShape(circleColor = ButtonBackgroundGreen)

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(text = "覚えている",fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.heightIn(10.dp))

                        Row(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircleShape(circleColor = ButtonBackgroundRed)

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(text = "覚えてない",fontSize = 15.sp)
                        }
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = room.roomName, color = BackgroundBlack)

                    Spacer(modifier = Modifier.width(15.dp))

                    Button(
                        onClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${room.roomId}")
                        },
                    ) {
                        Text(text = "学習", fontSize = 15.sp, color = BackgroundWhite)
                    }
                }
            }
        }
    }
}