package com.example.tumotanapp.feature.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.feature.presentation.detail.DetailViewModel
import com.example.tumotanapp.feature.presentation.home.component.CircleShape
import com.example.tumotanapp.feature.presentation.home.component.CustomCircleComponent
import com.example.tumotanapp.ui.theme.BackgroundWhite
import com.example.tumotanapp.ui.theme.ButtonBackgroundGreen
import com.example.tumotanapp.ui.theme.ButtonBackgroundRed
import com.example.tumotanapp.ui.theme.TextBlack

@ExperimentalMaterialApi
@Composable
fun DetailBottomSection(
    navController: NavController
){
    DetailBottomSectionContent(navController = navController)
}

@Composable
fun DetailBottomSectionContent(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
            .background(TextBlack.copy(alpha = 0.9f))
            .padding(all = 15.dp)
    ) {

        val state = viewModel.detailState.value.room

        state.forEach { roomDetail ->

            Text(
                text = roomDetail.roomName,
                color = BackgroundWhite,
                modifier = Modifier.
                padding(horizontal = 15.dp, vertical = 15.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ){
                Spacer(modifier = Modifier.height(10.dp))

                CustomCircleComponent(strokeWidth = 30f)

                Column{
                    Row(
                        modifier = Modifier.padding(start = 50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CircleShape(circleColor = ButtonBackgroundGreen)

                        Spacer(modifier = Modifier.width(30.dp))

                        Text(
                            text = "覚えている",
                            fontSize = 15.sp,
                            color = BackgroundWhite
                        )
                    }

                    Spacer(modifier = Modifier.heightIn(30.dp))

                    Row(
                        modifier = Modifier.padding(start = 50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircleShape(circleColor = ButtonBackgroundRed)

                        Spacer(modifier = Modifier.width(30.dp))

                        Text(
                            text = "覚えてない",
                            fontSize = 15.sp,
                            color = BackgroundWhite
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 35.dp, end = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = ButtonBackgroundGreen
                    ),
                    modifier = Modifier.width(120.dp).height(45.dp)
                ) {
                    Text(text = "得意", fontSize = 15.sp)
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = ButtonBackgroundRed
                    ),
                    modifier = Modifier.width(120.dp).height(45.dp)
                ) {
                    Text(text = "苦手", fontSize = 15.sp)
                }
            }

            Spacer(modifier = Modifier.fillMaxHeight())
        }

    }
}