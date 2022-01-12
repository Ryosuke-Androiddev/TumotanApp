package com.example.tumotanapp.feature.presentation.home.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tumotanapp.ui.theme.ButtonBackgroundGreen
import com.example.tumotanapp.ui.theme.ButtonBackgroundRed

@Composable
fun CustomCircleComponent(
    canvasSize: Dp = 150.dp,
    indicatorValue: Float = 100f,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = ButtonBackgroundRed, //バックグラウンドの色の状態 ここの色を赤にしてforegroundの緑の色を変化させるような処理を書けばいい
    strokeWidth: Float = 15f,
    correctForegroundColor: Color = ButtonBackgroundGreen
){
    val animatedIndicatorValue = remember {
        Animatable(initialValue = 0f)
    }

    LaunchedEffect(key1 = indicatorValue){
        animatedIndicatorValue.animateTo(indicatorValue * -1)
    }

    val percentage = (animatedIndicatorValue.value / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(2500)
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                //内側のサイズ
                val contentSize = size / 1.5f
                BackgroundIndicator(
                    componentSize = contentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = strokeWidth //後ろの幅
                )
                CorrectForegroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = contentSize,
                    indicatorColor = correctForegroundColor,
                    indicatorStrokeWidth = strokeWidth //後ろの幅
                )
            }
    ) {

    }
}

fun DrawScope.BackgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.CorrectForegroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Square
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}