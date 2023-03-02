package com.x.compose.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp


@Composable
fun baseText(content:String) {
    Text(
        text = content,
        //控制Text外部边框的一些属性，eg: Size Background
        modifier = Modifier.background(Color.White).padding(10.dp)
            .border(
                BorderStroke(
                    1.dp,
                    brush = Brush.horizontalGradient(listOf(Color.Yellow, Color.Green, Color.Blue), tileMode = TileMode.Clamp)
                )
            ),
        color = Color.Black
    )
}

@Composable
fun baseTextFieldValue(content:String) {
    Text(
        text = buildAnnotatedString {
            append(content)
            withStyle( style = SpanStyle(
                fontSize = 24.sp, color = Color.Blue)
            ){
                append("这是一段高亮的代码")
            }
        }
    )
}



@Composable
fun baseTextFiled() {
    TextFieldValue
        val content = remember{ mutableStateOf("请输入内容") }
        //文本字段
        TextField(
            value = content.value,
            onValueChange = { it->
                content.value = it
            }
        )
}

@Composable
fun baseBasicTextFiled() {
    val content = remember{ mutableStateOf(TextFieldValue()) }
    //文本字段
    BasicTextField(
        value = TextFieldValue(),
        onValueChange = { it->
            content.value = it
        }
    )
}



@Preview
@Composable
fun preBasicText() {
    Column(modifier = Modifier.background(Color.White).fillMaxSize().padding(20.dp)) {
        baseText("基础text")
        Spacer(Modifier.background(Color.White))
        baseTextFieldValue("基础text-buildAnnotatedString")
        baseText("baseTextFiled输入框 ：")
        baseTextFiled()
        baseText("baseBasicTextFiled输入框 ：")
        baseBasicTextFiled()
    }
}