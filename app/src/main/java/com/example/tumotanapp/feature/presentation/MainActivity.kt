package com.example.tumotanapp.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.tumotanapp.feature.presentation.detail.components.DetailScreenFun
import com.example.tumotanapp.feature.presentation.home.component.HomeScreenFun
import com.example.tumotanapp.feature.presentation.navigation.NavigationFun
import com.example.tumotanapp.feature.presentation.study.components.StudyCard
import com.example.tumotanapp.ui.theme.TumotanAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                }
            }
        }
    }
}