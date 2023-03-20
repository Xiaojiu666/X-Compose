package com.x.custom.edittext

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.x.compose.R
import com.x.custom.EditTextViewModel
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BasicTextFieldView(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {

    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    val keyBorderHeight = WindowInsets.ime.getBottom(LocalDensity.current)
    val isVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0

    val coroutineScope = rememberCoroutineScope()
    val offsetX = remember { Animatable(0f) }
    val offsetY = remember { Animatable(0f) }

    Box(
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxSize()
    ) {
        BasicTextField(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
                .fillMaxHeight(),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.Gray),
            decorationBox = {
                it()
            })
        Button(onClick = { visible = !visible }) {

        }

//
//        coroutineScope.launch {
//
//            launch {
//                offsetXFirst.animateTo(
//                    targetValue = targetValue,
//                    animationSpec = tween(
//                        durationMillis = 2000,
//                        delayMillis = 0))}
//
//            launch {
//                offsetYFirst.animateTo(
//                    targetValue = size.height.toFloat(),
//                    animationSpec = tween(
//                        durationMillis = 2000,
//                        delayMillis = 0))}
//        }

        AnimatedVisibility(
            modifier = Modifier
                .background(Color.White)
                .align(Alignment.BottomCenter)
               ,
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { 40.dp.roundToPx() }
            }
//                    + expandVertically(
//                // Expand from the top.
//                expandFrom = Alignment.Bottom
//            )
                    + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha =1f
            ),
//            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Box{
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .height(30.dp)
                    .offset {
                        IntOffset(
                            offsetX.value.toInt(),
                            offsetY.value.toInt()
                        )
                    }) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                }
            }
        }

    }
}


@Preview
@Composable
fun EditTextBottomBar() {
    BasicTextFieldView(value = TextFieldValue(text = "请输入内容")) {

    }
}

@Composable
fun EditTextView(editTextVIewModel: EditTextViewModel) {
    val editTextUiState by editTextVIewModel.editTextUiState.collectAsStateWithLifecycle()
    BasicTextFieldView(editTextUiState.textFieldValue) {
        editTextVIewModel.onValueChanged(it)
    }
}


// https://juejin.cn/post/6998038393003180046
// https://developer.android.com/jetpack/compose/text?hl=zh-cn
