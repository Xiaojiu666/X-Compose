package com.x.compose.customize.lotto

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.PointerEventType.Companion.Move
import androidx.compose.ui.input.pointer.PointerEventType.Companion.Press
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.theme.colorBackground


@Composable
fun LottoPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        var linePath by remember { mutableStateOf(Offset.Zero) }
        val path by remember { mutableStateOf(Path()) }
        val paint by remember {
            mutableStateOf(Paint().apply {
                alpha = 0f
                style = PaintingStyle.Stroke
                strokeWidth = 70f
                blendMode = BlendMode.SrcIn
                strokeJoin = StrokeJoin.Round
                strokeCap = StrokeCap.Round
            })
        }
        var canvas: Canvas? = null
        var bitmap: ImageBitmap? = null
        val paintBg = Paint().apply {
            color = Color.Gray
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .pointerInput("dragging") {
                awaitEachGesture {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            //按住时，更新起始点
                            Press -> {
                                path.moveTo(
                                    event.changes.first().position.x,
                                    event.changes.first().position.y
                                )
                            }
                            //移动时，更新起始点 移动时，记录路径path
                            Move -> {
                                linePath = event.changes.first().position
                            }
                        }
                    }
                }
            }
            .onSizeChanged {
                bitmap = Bitmap
                    .createBitmap(it.width, it.height, Bitmap.Config.ARGB_8888)
                    .asImageBitmap()
                canvas = Canvas(bitmap!!)
            }
            .drawWithContent {
                drawContent()
                drawImage(
                    image = bitmap!!,
                )
                canvas!!.drawRect(
                    Rect(
                        0f,
                        0f,
                        bitmap!!.width.toFloat(),
                        bitmap!!.height.toFloat()
                    ), paintBg
                )
                path.lineTo(linePath.x, linePath.y)
                canvas!!.drawPath(path, paint)
            }) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.mipmap.cat),
                contentDescription = ""
            )
            Text(text = "这是一只可爱的猫咪~~")
        }
    }
}
