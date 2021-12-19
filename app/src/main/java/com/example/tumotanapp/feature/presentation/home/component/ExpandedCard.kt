package com.example.tumotanapp.feature.presentation.home.component

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.presentation.home.HomeScreenViewModel
import com.example.tumotanapp.feature.presentation.navigation.Screen
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.COLLAPSE_ANIMATION
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.EXPANDED_ANIMATION
import com.example.tumotanapp.feature.presentation.util.PresentationConstants.FADE_IN_ANIMATION
import com.example.tumotanapp.ui.theme.*
import com.example.tumotanapp.R

@Composable
fun ExpandableCardFun(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController
){
    val allRoom = viewModel.roomState.value
    val expandedCard = viewModel.expandedCardList.collectAsState()

    if (allRoom.isLoading){
        Column{
            Spacer(modifier = Modifier.height(100.dp))
            CircularProgressIndicator()
        }
    } else {
        LazyColumn{

            //後々ここをstudyViewModelのリストのサイズに変更する
            itemsIndexed(allRoom.roomList){ _, room ->
                ExpandableCard(
                    room = room,
                    onCardArrowClick = { viewModel.cardArrowClicked(room.roomId) },
                    expanded = expandedCard.value.contains(room.roomId),
                    navController = navController
                )
            }
        }
    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableCard(
    room: Room,
    expanded: Boolean,
    onCardArrowClick: () -> Unit,
    navController: NavController
){
    //この上二つが難しい
    //targetValue と currentValue を同時に理解することができるのが,MutableTransitionState
    val transitionState = remember {
        MutableTransitionState(expanded).apply {

            //!がなければどのような挙動になる??
            targetState = !expanded
        }
    }
    val transition = updateTransition(targetState = transitionState, label = "transition")

    //拡張前後の色の違い
    val cardColor by transition.animateColor(
        {
            tween(durationMillis = EXPANDED_ANIMATION)
        },
        label = "background Color"
    ) {
        BackgroundWhite
    }

    //アニメーション中の横幅の大きさってこと
    val horizontalCardPadding by transition.animateDp({
        tween(durationMillis = EXPANDED_ANIMATION)
    },label = "horizontal padding with animation"
    ) {
        //ここの大きさ変えてみて理解する
        if (expanded) 48.dp else 24.dp
    }

    val cardElevation by transition.animateDp({
        tween(durationMillis = EXPANDED_ANIMATION)
    },label = "vertical scale of card"
    ) {
        5.dp
    }

    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = EXPANDED_ANIMATION,
            easing = FastOutSlowInEasing //別アニメーションでも試してみる
        )
    },label = "card corner shape"
    ) {
        16.dp
    }

    val arrowRotationDegree by transition.animateFloat({
        tween(
            durationMillis = EXPANDED_ANIMATION,
            easing = FastOutSlowInEasing //別アニメーションでも試してみる
        )
    },label = "arrow direction"
    ) {
        if (expanded) 180f else 0f //これで反転すんのか
    }

    Card(
        backgroundColor = cardColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalCardPadding,
                vertical = 12.dp
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = room.roomName,
                        color = TextBlack,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 20.dp,top = 20.dp,bottom = 20.dp)
                    )

                    IconButton(onClick = onCardArrowClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_down),
                            contentDescription = "Arrow" ,
                            modifier = Modifier.rotate(arrowRotationDegree),
                            tint = TextBlack
                        )
                    }
                }

                //この引数の入れ忘れをすると、常にtrueになってしまうので注意
                ExpandedContent(expanded,navController = navController,room)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandedContent(
    expanded: Boolean = true,
    navController: NavController,
    room: Room,
){
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION,
                easing = LinearOutSlowInEasing
            )
        )
    }

    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION,
                easing = LinearOutSlowInEasing
            )
        )
    }

    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION))
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(EXPANDED_ANIMATION))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(mediumPadding)
        ) {
            Spacer(modifier = Modifier.heightIn(60.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                CustomCircleComponent()

                Column{
                    Row(
                        modifier = Modifier.padding(start = 30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CircleShape(circleColor = ButtonBackgroundGreen)

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(text = "know",fontSize = 15.sp)
                    }

                    Spacer(modifier = Modifier.heightIn(10.dp))

                    Row(
                        modifier = Modifier.padding(start = 30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircleShape(circleColor = ButtonBackgroundRed)

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(text = "don't know",fontSize = 15.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.heightIn(40.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Get Started 👉",
                    modifier = Modifier.padding(start = 20.dp)
                )

                Spacer(modifier = Modifier.width(30.dp))

                CustomCircleButton(number = "Study Now", navController = navController, room)
            }
        }
    }
}

@Composable
fun CircleShape(
    circleColor: Color
) {
    Canvas(modifier = Modifier.size(1.dp),
        onDraw = {
            val size = 15.dp.toPx()
            drawCircle(
                color = circleColor,
                radius = size / 2f
            )
        })
}

//Level ごとの単語が表示される必要がある
@Composable
fun CustomCircleButton(
    number: String,
    navController: NavController,
    room: Room
){
    Button(
        onClick = {
            navController.navigate(Screen.DetailScreen.route + "/${room.roomId}")
        },
        colors = ButtonDefaults.outlinedButtonColors(contentColor =  BackgroundWhite),
    ) {
        Text(text = number,color = BackgroundWhite)
    }
}