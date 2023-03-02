package com.x.compose.viewgroup

import android.provider.SyncStateContract.Columns
import android.widget.GridView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices.PIXEL_3
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.x.compose.data.languages


@Composable
fun <T>  GridListView(data:List<T>,itemContent:@Composable (item: T)->Unit){

   var dataLists by  remember { mutableStateOf(data) }
    LazyColumn(modifier = Modifier.fillMaxSize()){
//        LazyVerticalGrid(columns = GridCells.Fixed(4)){
//            items(dataLists)  {
//                Box(modifier = Modifier.background(color = Color.Blue).fillMaxWidth(0.5f).fillMaxHeight(0.5f)){
//                    itemContent(it)
//                }
//            }
//        }
    }
}

@Preview(device = PIXEL_3)
@Composable
fun  PreviewGridListView(){
    GridListView(languages){
        Text(it, color = Color.Cyan)
    }

}