package com.x.compose.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mercedesbenz.core_ui.theme.subtitle2Bold
import com.x.compose.main.theme.baseWhite


val TOOLBAR_HEIGHT = 56.dp

@Composable
fun BaseToolbar(
    leftView: @Composable BoxScope.() -> Unit = {},
    centerView: @Composable BoxScope.() -> Unit = {},
    rightView: @Composable BoxScope.() -> Unit = {}
) {
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
            centerView(this)
        }

        Box(
            Modifier.align(Alignment.CenterStart)
        ) {
            leftView(this)
        }

        Box(
            Modifier.align(Alignment.CenterEnd)
        ) {
            rightView(this)
        }
    }
}

@Composable
fun BaseTitleToolbar(
    title: String,
) {
    BaseToolbar(
        centerView = {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = title,
                textAlign = TextAlign.Center,
                style = subtitle2Bold,
                color = baseWhite()
            )
        })
}

@Composable
fun BaseBackToolbar(
    title: String,
    onBackClick: () -> Unit
) {
    BaseToolbar(
        centerView = {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = title,
                textAlign = TextAlign.Center,
                style = subtitle2Bold,
                color = baseWhite()
            )
        }, leftView = {
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {
                        onBackClick()
                    },
                painter = painterResource(id = com.x.compose.R.drawable.ic_back),
                contentDescription = ""
            )
        })
}


@Preview
@Composable
fun preBaseTitleToolbar() {
    BaseTitleToolbar(title = "home")
}

@Preview
@Composable
fun preBaseBackToolbar() {
    BaseBackToolbar(title = "home") {

    }
}


