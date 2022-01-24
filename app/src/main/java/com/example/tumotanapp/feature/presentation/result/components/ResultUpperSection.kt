package com.example.tumotanapp.feature.presentation.result.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tumotanapp.feature.presentation.home.component.CustomCircleComponent
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.ui.theme.BackgroundWhite

@Composable
fun ResultUpperSection(
    navController: NavController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        CustomCircleComponent(canvasSize = 230.dp,indicatorValue = 85f, strokeWidth = 60f)

        Text(text = "理解度 85%", fontSize = 25.sp, color = BackgroundWhite)

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            }
        ) {
            Text(text = "Topに戻る", fontSize = 15.sp, color = BackgroundWhite)
        }
    }

}