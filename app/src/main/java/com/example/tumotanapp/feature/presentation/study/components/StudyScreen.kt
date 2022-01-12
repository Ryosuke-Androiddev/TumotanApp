package com.example.tumotanapp.feature.presentation.study.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.tumotanapp.feature.domain.model.Word
import com.example.tumotanapp.feature.presentation.components.CustomButtonComponents
import com.example.tumotanapp.feature.presentation.study.StudyViewModel
import com.example.tumotanapp.ui.theme.BackgroundBlack
import com.example.tumotanapp.ui.theme.BackgroundWhite
import com.example.tumotanapp.ui.theme.ButtonBackgroundRed

@ExperimentalCoilApi
@Composable
fun StudyScreenFun(
    navController: NavController,
){

    ShowData()

}

@ExperimentalCoilApi
@Composable
fun ShowData(
    viewModel: StudyViewModel = hiltViewModel()
){

    val wordList = viewModel.wordState.value.word
    val listSize = wordList.size

    var index by remember {
        mutableStateOf(0)
    }

    var current by remember { mutableStateOf(0) }

    val isLoaded = viewModel.wordState.value.isLoading

    //ここで，List sizeを返したことで参照先で比較ができなかったのかも
    val visible by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isLoaded){

            CircularProgressIndicator()

        } else {
            Box {
                val visibleCards: Int = StrictMath.min(visible,listSize - current)

                repeat(visibleCards){ idx ->

                    // 先頭のやつだけが一番大きくなる
                    val zIndex = 100f - idx
                    val scaleX = calculateScale(idx)
                    val offsetY = calculateOffset(idx)

                    val cardModifier = Modifier
                        .scale(scaleX, 1f)
                        .offset { IntOffset(1, offsetY) }
                        .align(Alignment.TopCenter)
                        .zIndex(zIndex)
                        .size(350.dp, 350.dp)

                    CardViewComponent(wordList = wordList, index = index, modifier = cardModifier)

                }
            }

            Spacer(modifier = Modifier.height(160.dp))

            //TODO you should define card Fun
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 45.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomButtonComponents(
                    title = "No",
                    modifier = Modifier.weight(1f),
                    backgroundColor = ButtonBackgroundRed
                ) {
                    if (current < wordList.lastIndex)
                        current += 1
                    else
                        current = 0
                }

                CustomButtonComponents(
                    title = "check",
                    modifier = Modifier.weight(1f),
                ) {
                    if (current < wordList.lastIndex)
                        current += 1
                    else
                        current = 0
                }
            }

            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CardViewComponent(
    wordList: List<Word>,
    index: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = BackgroundBlack
){

    wordList.forEach {
        CardContent(
            word = it,
            backgroundColor = backgroundColor,
            index = index,
            count = wordList.size,
            modifier = modifier
        )
    }
}

@ExperimentalCoilApi
@Composable
fun CardContent(
    word: Word,
    backgroundColor: Color = BackgroundBlack,
    index: Int,
    count: Int,
    modifier: Modifier = Modifier
){

    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 5.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = rememberImagePainter(
                    data = word.word
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = word.imageUrl,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(24.dp),
                color = BackgroundWhite
            )

            Text(
                text = "${index + 1}  of $count",
                color = BackgroundWhite
            )
        }
    }
}

//戦闘が一番小さくなるような工夫
private fun calculateScale(idx: Int): Float{
    return 1f - idx * (1f/10f)
}

//後半の方が大きくなる工夫
private fun calculateOffset(idx: Int): Int{
    return (32f * (idx + 1)).toInt()
}