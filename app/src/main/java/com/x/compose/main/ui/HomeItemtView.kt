package com.x.compose.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.x.compose.R
import com.x.compose.data.HomeNavigateItem


@Composable
fun HomeItemView(homeNavigateItem: HomeNavigateItem, onItemClick: (HomeNavigateItem) -> Unit) {
    Box(
        modifier = Modifier
            .height(160.dp)
            .width(160.dp)
            .padding(8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            )
            .clickable {
                onItemClick(homeNavigateItem)
            }
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .align(CenterHorizontally)
                    .size(64.dp),
                painter = painterResource(homeNavigateItem.icon),
                contentDescription = null
            )

            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(CenterHorizontally),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = homeNavigateItem.name,
                maxLines = 1
            )

            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(horizontal = 8.dp),
                fontSize = 14.sp,
                text = homeNavigateItem.desc,
                maxLines = 2
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
            "你好你好你好你好你好",
            "你好你好你好你好你好你好你好",
            "你好你好你好你好你好你好",
        )
    ) {

    }
}