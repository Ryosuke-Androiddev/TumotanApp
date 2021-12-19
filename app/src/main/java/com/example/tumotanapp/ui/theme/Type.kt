package com.example.tumotanapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tumotanapp.R

val staatliches = FontFamily(
    Font(R.font.staatliches,FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = staatliches,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = TextBlack
    ),
    body2 = TextStyle(
        fontFamily = staatliches,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        color = TextBlack
    )
)