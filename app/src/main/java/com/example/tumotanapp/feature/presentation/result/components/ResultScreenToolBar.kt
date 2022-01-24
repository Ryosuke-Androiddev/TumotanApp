package com.example.tumotanapp.feature.presentation.result.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tumotanapp.R
import com.example.tumotanapp.feature.presentation.home.component.CustomCircleComponent
import com.example.tumotanapp.feature.presentation.util.PresentationConstants
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.AppBarCollapsedHeight
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.AppBarExpendedHeight
import com.example.tumotanapp.ui.theme.BackgroundBlack
import com.example.tumotanapp.ui.theme.BackgroundWhite
import com.example.tumotanapp.ui.theme.Shapes
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

@Composable
fun ResultScreenToolBar(
    scrollState: LazyListState,
    navController: NavController
){

    val upperHeight = PresentationConstants.AppBarExpendedHeight - PresentationConstants.AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) {
        upperHeight.roundToPx()
    } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = BackgroundBlack,
        modifier = Modifier
            .height(
                PresentationConstants.AppBarExpendedHeight
            )
            .offset {
                IntOffset(x = 0, y = -offset)
            },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(upperHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }
            ) {
                ResultUpperSection(navController = navController)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Result",
                    fontSize = 25.sp,
                    color = BackgroundWhite,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(horizontal = (16 + 2 * offsetProgress).dp)
                        .scale(1f - 0.1f * offsetProgress)
                )
            }
        }
    }
}