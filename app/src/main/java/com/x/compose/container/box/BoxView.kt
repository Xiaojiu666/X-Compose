package com.x.compose.container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BaseBox() {
    Box(modifier = Modifier
        .background(color = Color.Blue)
        .fillMaxWidth(0.3f)
        .fillMaxHeight(0.3f)) {
    }
}

@Preview
@Composable
fun PreviewBaseBox() {
    BaseBox()
}