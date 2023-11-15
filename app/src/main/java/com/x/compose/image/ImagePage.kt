package com.x.compose.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.text.itemContainer
import com.x.compose.theme.colorBackground
import com.x.compose.theme.colorPrimary


@Composable
fun ImagePage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) { it ->
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            item {
                itemContainer("基础ImageView") {
                    Image(
                        modifier = Modifier.size(64.dp),
                        painter = painterResource(id = R.mipmap.cat),
                        contentDescription = ""
                    )
                }
            }
            item {
                itemContainer("黑白化图片") {
                    val matrix = ColorMatrix()
                    matrix.setToSaturation(0F)
                    Image(
                        modifier = Modifier.size(64.dp),
                        painter = painterResource(id = R.mipmap.cat),
                        contentDescription = "",
                        colorFilter = ColorFilter.colorMatrix(matrix)
                    )
                }
            }
            item {
                val context = LocalContext.current
                itemContainer("Coil AsyncImage") {
                    AsyncImage(
                        modifier = Modifier.size(64.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.baidu.com/img/flexible/logo/pc/result.png")
                            .placeholder(R.drawable.baseline_downloading_24)
                            .build(),
                        contentDescription = "",
                        imageLoader = context.imageLoader,
                    )
                }
            }

            item {
                itemContainer("其他Painter") {
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = ColorPainter(Color.Red),
                        contentDescription = ""
                    )
                }
            }
            item {
                itemContainer("颜色矩阵控制") {
                    SelectorMatrix()
                }
            }
        }
    }
}

@Preview
@Composable
private fun SelectorMatrix() {
    var contrast by remember { mutableStateOf(1f) }
    var brightness by remember { mutableStateOf(0f) }
    val colorMatrix by remember {
        mutableStateOf(
            floatArrayOf(
                contrast, 0f, 0f, 0f, brightness,
                0f, contrast, 0f, 0f, brightness,
                0f, 0f, contrast, 0f, brightness,
                0f, 0f, 0f, 1f, 0f
            )
        )
    }
    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            painter = painterResource(id = R.mipmap.cat),
            contentDescription = "",
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "亮度:")
            Slider(
                valueRange = -255f..255f,
                value = brightness,
                colors = SliderDefaults.colors(
                    thumbColor = colorPrimary(),
                    activeTrackColor = colorPrimary()
                ),
                onValueChange = {
                    brightness = it
                    colorMatrix[4] = it
                    colorMatrix[9] = it
                    colorMatrix[14] = it
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "饱和度:")
            Slider(
                valueRange = -1f..10f,
                value = contrast,
                colors = SliderDefaults.colors(
                    thumbColor = colorPrimary(),
                    activeTrackColor = colorPrimary()
                ),
                onValueChange = {
                    contrast = it
                    colorMatrix[0] = it
                    colorMatrix[6] = it
                    colorMatrix[12] = it
                }
            )
        }


    }
}