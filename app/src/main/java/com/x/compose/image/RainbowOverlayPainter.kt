package com.x.compose.image

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import kotlin.math.roundToInt

class RainbowOverlayPainter(private val image: ImageBitmap) : Painter() {

    override val intrinsicSize: Size
        get() = Size(image.width.toFloat(), image.height.toFloat())

    override fun DrawScope.onDraw() {

        drawImage(
            image,
            IntOffset.Zero,
            IntSize(image.width, image.height),
            dstSize = IntSize(
                this@onDraw.size.width.roundToInt(),
                this@onDraw.size.height.roundToInt()
            )
        )

        drawRect(
            brush = Brush.verticalGradient(
                listOf(Color.Black,Color.Red, Color.Yellow, Color.Blue, Color.Green, Color.Cyan),
            ),
            blendMode = BlendMode.Overlay
        )
    }
}