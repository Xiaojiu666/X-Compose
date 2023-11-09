package com.x.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.x.compose.R
import com.x.compose.data.HomeNavigateItem
import com.x.compose.base.ui.BaseTitleToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.theme.colorBackground

@Composable
fun HomePage(
    homeItem: List<HomeNavigateItem>, onItemClick: (HomeNavigateItem) -> Unit
) {
    BaseScaffoldPage(toolbar = { BaseTitleToolbar(title = stringResource(id = R.string.app_name)) }) {
        Box(
            modifier = Modifier
                .background(colorBackground())
                .padding(it)
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2)
            ) {
                items(homeItem) {
                    HomeItemView(it) {
                        onItemClick(it)
                    }
                }
            }
        }
    }
}


