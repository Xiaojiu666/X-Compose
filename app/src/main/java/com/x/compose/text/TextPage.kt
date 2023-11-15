package com.x.compose.text

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.theme.colorBackground
import com.x.compose.theme.colorPrimary
import com.x.compose.theme.colorSecondary
import com.x.compose.theme.colorTertiary
import com.x.compose.theme.subtitle1Bold

@Composable
fun BaseTextPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            item {
                itemContainer("基础Text") {
                    baseText(qiuci)
                }
            }
            item {
                itemContainer("基础Annotated") {
                    baseTextAnnotatedString(qiuci)
                }
            }

            item {
                itemContainer("进阶Text") {
                    AdvancedText(denggao)
                }
            }

            item {
                itemContainer("可点击Text") {
                    AnnotatedClickableText(
                        denggao, listOf(
                            IntRange(4, 7),
                            IntRange(12, 15),
                            IntRange(20, 23),
                        )
                    )
                }
            }
            item {
                itemContainer("可选择Text") {
                    SelectableText(denggao)
                }
            }
            item {
                itemContainer("特殊字体") {
                    TextFontFamily(denggao)
                }
            }
        }
    }
}

@Composable
fun itemContainer(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(colorSecondary(), RoundedCornerShape(5.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = subtitle1Bold)
        content()
    }
}

@Composable
fun baseText(content: String) {
    Text(
        text = content, color = Color.Black
    )
}

@Composable
fun AdvancedText(content: String) {
    val offset = Offset(5f, 10.0f)
    Text(
        text = content, modifier = Modifier
            .background(Color.White)
            .border(
                BorderStroke(
                    1.dp, brush = Brush.verticalGradient(
                        listOf(Color.Yellow, Color.Green, Color.Blue), tileMode = TileMode.Clamp
                    )
                )
            ), color = Color.Black, style = TextStyle(
            fontSize = 16.sp, shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}


@Composable
fun baseTextAnnotatedString(content: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 24.sp, color = Color.Blue
                )
            ) {
                append("秋词\n")
            }
            append(content)
            addStyle(
                SpanStyle(
                    color = Color.Blue, textDecoration = TextDecoration.Underline
                ), 7, 10
            )
        },
        color = Color.Black,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun AnnotatedClickableText(content: String, range: List<IntRange>) {
    val annotatedText = buildAnnotatedString {
        append(content)
        range.forEach {
            addStyle(
                style = SpanStyle(
                    color = Color.Blue, textDecoration = TextDecoration.Underline
                ), it.first, it.last
            )
        }
    }

    ClickableText(
        text = annotatedText,
        style = TextStyle(textAlign = TextAlign.Center),
        onClick = { offset ->
            val clickText = range.find {
                offset in it.first..it.last
            }
            clickText?.let {
                println("clickText ${content.substring(it)}")
            }
        })
}


@Composable
fun SelectableText(content: String) {
    SelectionContainer {
        Text(content)
    }
}

@Composable
fun TextFontFamily(content: String) {
    Text(
        content, fontFamily = FontFamily(
            Font(
                resId = R.font.number, weight = FontWeight.Bold, style = FontStyle.Italic
            )
        ), fontSize = 16.sp
    )
}
