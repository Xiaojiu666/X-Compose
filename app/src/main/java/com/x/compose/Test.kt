package com.x.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import com.x.compose.data.languages
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun <T> GridListView(data: List<T>, itemContent: @Composable (item: T) -> Unit) {

    var dataLists by remember { mutableStateOf(data) }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var (text, list) = createRefs()
        Text(text = "测试文案", modifier = Modifier
            .constrainAs(text) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top, 0.dp)
            })
        Box(modifier = Modifier
            .constrainAs(list) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(text.bottom, 10.dp)
                bottom.linkTo(parent.bottom)
            }
            .fillMaxWidth()) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(dataLists){

                }
            }
//        LazyVerticalGrid(columns = GridCells.Fixed(4)){
//            items(dataLists)  {
//                Box(modifier = Modifier.background(color = Color.Blue).fillMaxWidth(0.5f).fillMaxHeight(0.5f)){
//                    itemContent(it)
//                }
//            }
//        }
        }
    }

}

@Preview(device = Devices.PIXEL_3)
@Composable
fun PreviewGridListView() {
    GridListView(languages) {
        Text(it, color = Color.Cyan)
    }

}