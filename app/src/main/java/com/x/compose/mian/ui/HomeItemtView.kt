package com.x.compose.mian.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.x.compose.HomeNavigateItem
import com.x.compose.R


@Composable
fun HomeItemView(homeNavigateItem: HomeNavigateItem, onItemClick: (HomeNavigateItem) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            )
            .clickable {
                onItemClick(homeNavigateItem)
            }
            .height(108.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                modifier = Modifier.align(CenterHorizontally),
                painter = painterResource(homeNavigateItem.icon),
                contentDescription = null
            )

            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = homeNavigateItem.navigate
            )

            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = homeNavigateItem.navigate
            )
        }

    }
}

@Preview
@Composable
fun preHomeItemView() {
    HomeItemView(
        HomeNavigateItem(
            R.mipmap.ic_logo,
            "你好",
            "你好"
        )
    ){

    }
}