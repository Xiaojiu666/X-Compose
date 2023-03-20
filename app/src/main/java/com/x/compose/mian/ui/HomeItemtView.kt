package com.x.compose.mian.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.x.compose.HomeNavigateItem


@Composable
fun HomeItemView(homeNavigateItem: HomeNavigateItem){

    Box(modifier = Modifier.fillMaxSize()){

        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(painter = painterResource(homeNavigateItem.icon),
                contentDescription = null)

            Text(text = homeNavigateItem.navigate)
        }

    }
}

@Preview
@Composable
fun preHomeItemView(){
}