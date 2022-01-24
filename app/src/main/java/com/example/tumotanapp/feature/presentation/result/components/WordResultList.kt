package com.example.tumotanapp.feature.presentation.result.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity
import com.example.tumotanapp.feature.presentation.result.ResultScreenViewModel
import com.example.tumotanapp.feature.presentation.study.components.ListProvider
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.AppBarExpendedHeight
import com.example.tumotanapp.ui.theme.BackgroundBlack
import com.example.tumotanapp.ui.theme.BackgroundWhite


@Composable
fun WordResultListItem(
    scrollState: LazyListState,
    acceptedWordList: List<AcceptedWordEntity> = emptyList(),
    rejectedWordList: List<RejectedWordEntity> = emptyList()
) {
    LazyColumn(
        contentPadding = PaddingValues(top = AppBarExpendedHeight),
        state = scrollState
    ) {
        item {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                acceptedWordList.forEach { word ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .height(75.dp),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column {
                                Text(
                                    text = word.word,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                )
                                Text(
                                    text = word.meaning,
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                rejectedWordList.forEach { word ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .height(75.dp),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column {
                                Text(
                                    text = word.word,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                )
                                Text(
                                    text = word.meaning,
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}