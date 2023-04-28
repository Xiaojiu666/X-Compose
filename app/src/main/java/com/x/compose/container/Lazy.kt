package com.x.compose.container

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TagView() {
        val bottomState = rememberBottomSheetScaffoldState()
        val scope = rememberCoroutineScope()
        Divider(thickness = 0.5.dp, color = Color.Red)
        BottomSheetScaffold(scaffoldState = bottomState, topBar = {
            TopAppBar(navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }, title = {
                Text(text = "底部滑出菜单")
            })
        }, sheetContent = {
            Box(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Text(text = "向上可滑出底部菜单")
            }
            Column(
                Modifier
                    .padding(64.dp)
                    .fillMaxSize()
                , horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "我是底部菜单的内容")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    scope.launch {
//                        bottomState.bottomSheetState.expand()
                        bottomState.bottomSheetState.collapse()
                    }
                }) {
                    Text("关闭底部菜单")
                }
            }
        }, sheetPeekHeight = 130.dp, modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()
        ) {
            Text("我是内容")
        }
    }


//    val items = listOf(
//        "item1",
//        "item2",
//        "item3",
//        "item4",
//        "item5",
//        "item6",
//        "item7",
//        "item8",
//        "item9",
//        "item10"
//    )
//    val screenWidth = LocalConfiguration.current.screenWidthDp
//    Column(
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalAlignment = Alignment.Start,
//    ) {
//        var rowItems = mutableListOf<String>()
//        items.forEachIndexed { index, item ->
//            rowItems.add(item)
//            if (index == items.lastIndex || rowItems.width() > screenWidth.dp - 32.dp) {
//                itemRow(rowItems)
//                rowItems = mutableListOf()
//            }
//        }
//    }
//}



@Composable
fun itemRow(items: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items.forEach { item ->
            Text(
                text = item,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            )
        }
    }
}

fun List<String>.width(): Dp {
    var width = 0.dp
    forEach { item ->
        width += (16.dp + item.width() + 16.dp)
    }
    return width
}

fun String.width(): Dp {
    val paint = Paint()
    paint.textSize = 16f
    return paint.measureText(this).dp
}
