package com.example.tumotanapp.feature.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DisplayTitleText(
    title: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    startPadding: Int = 0,
    endPadding: Int = 0
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

        Text(
            text = title,
            fontSize = 20.sp,
            modifier = modifier.padding(start = startPadding.dp, end = endPadding.dp),
        )
        
        Spacer(modifier = Modifier.width(300.dp))

    }
}