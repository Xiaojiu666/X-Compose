package com.x.compose.animate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.data.HomeNavigateItem
import com.x.compose.home.HomeItemView
import com.x.compose.theme.colorBackground


@Composable
fun AnimatePage(
    customItems: List<HomeNavigateItem>,
    onItemClick: (HomeNavigateItem) -> Unit,
    onBackClick: () -> Unit
) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        LazyVerticalGrid(
            modifier = Modifier
                .background(colorBackground())
                .padding(it), columns = GridCells.Fixed(2)
        ) {
            items(customItems) {
                HomeItemView(it) {
                    onItemClick(it)
                }
            }
        }
    }
}
