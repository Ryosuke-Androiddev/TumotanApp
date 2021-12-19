package com.example.tumotanapp.feature.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tumotanapp.R
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.feature.presentation.util.PresentationConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreenFun(
    navController: NavController,
){

    val scale = remember{
        Animatable(0f)
    }

    val overshootInterpolator = remember {
        OvershootInterpolator(3f)
    }

    LaunchedEffect(key1 = true){

        withContext(Dispatchers.Main){
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )

            delay(PresentationConstants.SPLASH_SCREEN_DURATION)

            navController.navigate(Screen.HomeScreen.route)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "splash",
            modifier = Modifier.scale(scale = scale.value)
        )
    }
}