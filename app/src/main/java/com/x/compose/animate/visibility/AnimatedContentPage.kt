package com.x.compose.animate.visibility

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.text.itemContainer
import com.x.compose.theme.colorBackground

@OptIn(ExperimentalTextApi::class, ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = "AnimatedContent") {
            onBackClick()
        }
    }) {
        var checked by remember { mutableStateOf(true) }
        Switch(checked = checked, onCheckedChange = {
            checked = it
        })
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            item {
                itemContainer(title = "animateFloatAsState") {
                    Row {
                        var count by remember { mutableStateOf(0) }
                        Button(onClick = { count++ }) {
                            Text("Add")
                        }
                        AnimatedContent(targetState = count) { targetCount ->
                            // Make sure to use `targetCount`, not `count`.
                            Text(text = "Count: $targetCount")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CircleCat() {
    Image(
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.mipmap.cat),
        contentDescription = ""
    )
}