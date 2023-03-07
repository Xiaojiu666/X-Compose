package com.x.compose.container.colunm

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 1..100) {
            Box(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .fillMaxWidth()
                        .height(30.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewColumnView() {
    ColumnView()
}