package com.example.tumotanapp.feature.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tumotanapp.R
import com.example.tumotanapp.ui.theme.BackgroundBlack
import com.example.tumotanapp.ui.theme.ButtonBackgroundGreen

@Composable
fun CustomButtonComponents(
    title: String = "",
    textColor: Color = BackgroundBlack,
    backgroundColor: Color = ButtonBackgroundGreen,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    OutlinedButton(
        modifier= Modifier.size(100.dp),
        onClick = onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = backgroundColor
        )
    ){
        if (title == "check"){
            Icon(
                modifier= Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Check",
                tint = textColor
            )
        } else{
            Icon(
                modifier= Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.ic_clear),
                contentDescription = "No",
                tint = textColor
            )
        }
    }
}