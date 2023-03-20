package com.x.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.x.compose.mian.ui.HomeItemView
import com.x.compose.mian.ui.HomeToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageView(homeItem: List<HomeNavigateItem>){
    Scaffold(topBar = {HomeToolbar()}) {
        Box(modifier = Modifier.padding(it)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2)
            ) {
                items(homeItem){
                    HomeItemView(it)
                }
            }
        }
    }
}


@Preview
@Composable
fun PreMainView(){
    HomePageView(listOf(
        HomeNavigateItem(R.drawable.ic_launcher_background,""),
        HomeNavigateItem(R.drawable.ic_launcher_background,"")))
}