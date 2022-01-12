package com.example.tumotanapp.feature.presentation.study.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
fun StudyCard(
    viewModel: StudyViewModel = hiltViewModel(),
    navController: NavController
){

    //val wordList = viewModel.wordState.value.word
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val cardHeight = screenHeight - 200.dp

    val wordList = ListProvider.listProvider

    var current by remember { mutableStateOf(0) }
    val visible by remember { mutableStateOf(wordList.size) }

    val listSize = wordList.size

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Spacer(modifier = Modifier.height(80.dp))

        Box {

            val visibleCard: Int = StrictMath.min(visible,listSize - current)


            wordList.asReversed().forEachIndexed { index, word ->

                DraggableCard(
                    word = word,
                    modifier = Modifier
                        .size(350.dp,400.dp),
                    onSwiped = { _, word ->
                        //TODO
                    }
                ) {
                    CardContents(word = word, index = index, count = listSize)
                }
            }

        }

        Spacer(modifier = Modifier.height(130.dp))

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
                //TODO
            }

            CustomButtonComponents(
                title = "check",
                modifier = Modifier.weight(1f),
            ) {
                //TODO
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }

}

@ExperimentalCoilApi
@Composable
fun CardContents(
    word: Word,
    backgroundColor: Color = BackgroundBlack,
    index: Int,
    count: Int,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxSize(),
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

private fun calculateScale(idx: Int): Float{
    return 1f - idx * (1f/10f)
}

//後半の方が大きくなる工夫
private fun calculateOffset(idx: Int): Int{
    return (32f * (idx + 1)).toInt()
}