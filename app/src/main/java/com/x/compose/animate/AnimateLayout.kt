package com.x.compose.animate

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp


@Composable
fun TestAnimatedVisibility() {
    var editable by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top)
    ) {
        Button(onClick = { editable = !editable }) {

        }
        //默认情况下，内容以垂直淡入和扩大的方式出现，以淡出和缩小的方式消失。
        AnimatedVisibility(visible = editable) {
            Text(text = "9x9x9x9x9x9x9x9x")
        }

        //可以通过指定 EnterTransition 和 ExitTransition 来改变这边效果
        val density = LocalDensity.current
        AnimatedVisibility(visible = editable,
            //横向淡入
            enter =
            slideInHorizontally {
                with(density) { -40.dp.roundToPx() }
            } + expandHorizontally(
                expandFrom = Alignment.Start
            ) + fadeIn(
                initialAlpha = 0.5f
            ),
            //横向淡出
            exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()) {
            Text(text = "9x9x9x9x9x9x9x9x")
        }


    }
}

@Composable
fun TestCrossfade() {
    var currentPage by remember { mutableStateOf("A") }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top)
    ) {
        Button(onClick = { currentPage = "B" }) {

        }

        Crossfade(targetState = currentPage) { screen ->
            when (screen) {
                "A" -> Text("Page A")
                "B" -> Text("Page B")
            }
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TestAnimatedContent() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        Button(onClick = { count-- }) {
            Text("Delete")
        }
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(text = "$targetCount")
        }
    }
}

@Composable
fun ContentSizeAnimationDemo() {

    var expanded by remember { mutableStateOf(false) }

    val icon = if (expanded) Icons.Filled.Delete else Icons.Filled.Menu

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .animateContentSize()
    ) {

        Icon(
            icon,
            contentDescription = "Icon",
            modifier = Modifier.clickable { expanded = !expanded }
        )

        if (expanded) {
            Text(text = "Additional content")
        }

    }

}