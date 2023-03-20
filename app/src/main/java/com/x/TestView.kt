package com.x

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val density = LocalDensity.current
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
            Text(text = "移动文案")
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