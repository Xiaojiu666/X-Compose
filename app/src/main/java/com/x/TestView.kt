package com.x

import androidx.compose.animation.*
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextMotion.Companion.Animated
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.x.compose.text.baseText

//https://developer.android.com/jetpack/compose/animation?hl=zh-cn#animatable
@Composable
fun TestView() {
    var visible by remember { mutableStateOf(true) }
    var padding by remember { mutableStateOf(0.dp) }
    //https://developer.aliyun.com/article/1123887
    val size by animateDpAsState(
        targetValue =if (visible) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 1000))

    val density = LocalDensity.current
    val anim = remember {
        TargetBasedAnimation(
            animationSpec = tween(200),
            typeConverter = Float.VectorConverter,
            initialValue = 0f,
            targetValue = 100f
        )
    }
    LaunchedEffect(anim) {
        val startTime = withFrameNanos { it }
        val playTime = withFrameNanos { it } - startTime
        val animationValue = anim.getValueFromNanos(playTime)
        println("startTime : $startTime, playTime : $playTime , animationValue : $animationValue")
        padding = animationValue.dp
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Button(
            onClick = { visible = !visible },
        ) {
            Text(text = "点我移动")
        }
        Box(
            modifier = Modifier
                .background(Color.Red)
                .padding(
                    top = 100.dp,
                    start = 100.dp
                )
                .background(Color.White),
        ) {
            Text(modifier =Modifier.padding(top = size), text = "移动文案")
        }
//        AnimatedVisibility(
//            modifier = Modifier
//                .background(Color.Red)
//                .padding(
//                    top = 100.dp,
//                    start = 100.dp
//                )
//                .background(Color.White),
//            visible = visible,
//            enter = slideIn(
//                initialOffset = { IntOffset(-50, -50) },
//            ),
//            exit = slideOut(
//                targetOffset = { IntOffset(0, -100) },
//            )
//        ) {
//            Text(text = "移动文案")
//        }
    }
}