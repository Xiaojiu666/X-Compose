package com.x.custom.edittext

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditTextView(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    Box(modifier = Modifier.background(color = Color.Yellow).fillMaxSize()){
        BasicTextField(value = value,
            onValueChange = onValueChange ,
            cursorBrush = SolidColor(Color.Gray),
            modifier =Modifier.background(color = Color.Red),
            decorationBox = {
                it()
            },)
    }
}

@Preview
@Composable
fun preEditTextView(){
    var text by remember { mutableStateOf(TextFieldValue("请输入内容")) }
    EditTextView(text){
        text = it
    }
}

// https://juejin.cn/post/6998038393003180046
