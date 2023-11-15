package com.x.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.data.HomeNavigateItem
import com.x.compose.theme.body1
import com.x.compose.theme.colorBackground
import com.x.compose.theme.colorPrimary
import com.x.compose.theme.colorSecondary
import com.x.compose.theme.colorTertiary
import com.x.compose.theme.subtitle1Bold


@Composable
fun HomeItemView(homeNavigateItem: HomeNavigateItem, onItemClick: (HomeNavigateItem) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(colorSecondary(), RoundedCornerShape(5.dp))
            .padding(12.dp)
            .clickable {
                onItemClick(homeNavigateItem)
            }
    ) {
        Text(
            textAlign = TextAlign.Start,
            style = subtitle1Bold,
            color = colorPrimary(),
            text = homeNavigateItem.name,
            maxLines = 1
        )

        Text(
            textAlign = TextAlign.Center,
            style = body1,
            color = colorPrimary(),
            text = homeNavigateItem.desc,
            maxLines = 2
        )
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