package com.example.tumotanapp.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.tumotanapp.feature.presentation.navigation.NavigationFun
import com.example.tumotanapp.ui.theme.TumotanAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TumotanAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {

                    val navController = rememberNavController()

                    NavigationFun(navController = navController)

                    //DetailScreenFun(navController = navController)

                    //ResultScreenFun(navController = navController)


                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimationExample(){

    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Text("Hello", Modifier.fillMaxWidth().height(200.dp))
    }
}