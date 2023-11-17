package com.x.compose.canvas

import android.widget.ImageView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
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


@OptIn(ExperimentalTextApi::class)
@Composable
fun CanvasPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            item {
                itemContainer("基础Canvas") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        val canvasQuadrantSize = size / 2F
                        drawRect(
                            color = Color.Magenta,
                            size = canvasQuadrantSize
                        )
                    }
                }
            }
            item {
                itemContainer("坐标系") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0f),
                            end = Offset(x = 0f, y = canvasHeight),
                            color = Color.Blue
                        )
                    }
                }
            }

            item {
                itemContainer("缩放") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        scale(scaleX = 8f, scaleY = 10f) {
                            drawCircle(Color.Blue, radius = 3.dp.toPx())
                        }
                    }
                }
            }
            item {
                itemContainer("平移") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        translate(left = 10f, top = -30f) {
                            drawCircle(Color.Red, radius = 10.dp.toPx())
                        }
                    }
                }
            }

            item {
                itemContainer("旋转") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        rotate(degrees = 45F) {
                            drawRect(
                                color = Color.Gray,
                                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                                size = size / 3F
                            )
                        }
                    }
                }
            }

            item {
                val textMeasurer = rememberTextMeasurer()
                itemContainer("绘制文案") {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(80.dp)
                    ) {
                        val measuredText =
                            textMeasurer.measure(
                                AnnotatedString(denggao),
                                style = TextStyle(fontSize = 16.sp)
                            )
                        drawRect(Color.Cyan, size = measuredText.size.toSize())
                        drawText(measuredText)
                    }
                }
            }

            item {
                var pointerOffset by remember {
                    mutableStateOf(Offset(0f, 0f))
                }
                itemContainer("drawWithContent") {
                    Image(
                        painter = painterResource(id = R.mipmap.cat),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput("dragging") {
                                detectDragGestures { change, dragAmount ->
                                    pointerOffset += dragAmount
                                }
                            }
                            .onSizeChanged {
                                pointerOffset = Offset(it.width / 2f, it.height / 2f)
                            }
                            .drawWithContent {
                                drawContent()
                                // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                                drawRect(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black,
                                            Color.Red,
                                            Color.Yellow,
                                            Color.Blue,
                                            Color.Green,
                                            Color.Cyan
                                        ), startY = pointerOffset.y ,
                                    ),
                                    blendMode = BlendMode.Overlay
                                )
                            }
                    )
                }
            }

            item {
                var pointerOffset by remember {
                    mutableStateOf(Offset(0f, 0f))
                }
                itemContainer("drawWithContent") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput("dragging") {
                                detectDragGestures { change, dragAmount ->
                                    pointerOffset += dragAmount
                                }
                            }
                            .onSizeChanged {
                                pointerOffset = Offset(it.width / 2f, it.height / 2f)
                            }
                            .drawWithContent {
                                drawContent()
                                // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                                drawRect(
                                    Brush.radialGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        center = pointerOffset,
                                        radius = 100.dp.toPx(),
                                    )
                                )
                            }
                    ) {
                        Image(
                            modifier = Modifier.padding(10.dp),
                            painter = painterResource(id = R.mipmap.cat),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}