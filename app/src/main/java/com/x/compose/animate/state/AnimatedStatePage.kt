package com.x.compose.animate.state

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.text.itemContainer
import com.x.compose.theme.colorBackground

@OptIn(ExperimentalTextApi::class, ExperimentalAnimationApi::class)
@Composable
fun AnimatedStatePage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = "Animated*State") {
            onBackClick()
        }
    }) {
        var checked by remember { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .padding(it)
                .statusBarsPadding()
        ) {
            Switch(checked = checked, onCheckedChange = {
                checked = it
            })
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                item {
                    itemContainer(title = "animateFloatAsState") {
                        val alpha: Float by animateFloatAsState(if (checked) 1f else 0.5f)
                        val height: Dp by animateDpAsState(if (checked) 59.dp else 100.dp)
                        Box(
                            Modifier
                                .fillMaxSize()
                                .height(height)
                                .graphicsLayer(alpha = alpha)
                                .background(Color.Red)
                        )
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