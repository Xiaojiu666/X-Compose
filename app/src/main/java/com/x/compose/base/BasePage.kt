package com.x.compose.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.data.HomeNavigateItem


@Composable
fun BasePageRoute(baseItem: List<HomeNavigateItem>, onItemClick: (HomeNavigateItem) -> Unit) {
    BasePage(baseItem = baseItem, onItemClick = onItemClick)
}

@Composable
fun BasePage(baseItem: List<HomeNavigateItem>, onItemClick: (HomeNavigateItem) -> Unit) {

    LazyColumn {
        items(baseItem) {
            BaseItem(it)
        }
    }
}

@Composable
fun BaseItem(baseItem: HomeNavigateItem) {

    Column(modifier = Modifier.height(48.dp)) {
        Text(text = baseItem.name)
        Text(text = baseItem.desc)
    }

}


@Composable
@Preview
fun PreBaseItem() {
    BaseItem(
        HomeNavigateItem(
            R.mipmap.ic_logo,
            "你好你好你好你好你好",
            "你好你好你好你好你好你好你好",
            "你好你好你好你好你好你好",
        )
    )
}


