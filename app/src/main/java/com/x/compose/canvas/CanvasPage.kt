package com.x.compose.canvas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.text.AdvancedText
import com.x.compose.text.AnnotatedClickableText
import com.x.compose.text.SelectableText
import com.x.compose.text.TextFontFamily
import com.x.compose.text.baseText
import com.x.compose.text.baseTextAnnotatedString
import com.x.compose.text.denggao
import com.x.compose.text.itemContainer
import com.x.compose.text.qiuci
import com.x.compose.theme.colorBackground


@Composable
fun CanvasPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            item {
                itemContainer("基础ImageView") {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.mipmap.cat),
                        contentDescription = ""
                    )
                }
            }
            item {
                itemContainer("基础Annotated") {

                }
            }

            item {
                itemContainer("进阶Text") {}
            }

            item {
                itemContainer("可点击Text") {

                }
            }
        }
    }
}