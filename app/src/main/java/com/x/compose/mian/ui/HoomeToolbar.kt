package com.x.compose.mian.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mercedesbenz.core_ui.theme.subtitle2Bold
import com.x.compose.mian.theme.baseWhite


val TOOLBAR_HEIGHT = 56.dp

@Composable
fun HomeToolbar(){
    Box(
        Modifier
            .background(Color.Black)
            .statusBarsPadding()
            .padding(11.dp, 0.dp, 16.dp, 0.dp)
            .fillMaxWidth()
            .height(TOOLBAR_HEIGHT)
    ) {
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(com.x.compose.R.string.app_name),
                textAlign = TextAlign.Center,
                style = subtitle2Bold,
                color = baseWhite()
            )
        }
    }
}

@Preview
@Composable
fun preHomeToolbar(){
    HomeToolbar()
}
