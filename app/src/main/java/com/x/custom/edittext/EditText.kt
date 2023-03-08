package com.x.custom.edittext

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.x.compose.R
import com.x.custom.EditTextViewModel


@Composable
fun BasicTextFieldView(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Box(
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .height(300.dp)
    ) {
        BasicTextField(
            modifier = Modifier.background(color = Color.Red).fillMaxWidth().fillMaxHeight(),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.Gray),
            decorationBox = {
                it()
            })

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .align(Alignment.BottomCenter)
            .height(30.dp)){
            Row( modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .height(30.dp)) {
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
                Image(modifier = Modifier.size(30.dp), painter = painterResource(R.mipmap.icon_text), contentDescription = "")
            }
        }
    }
}


@Preview
@Composable
fun EditTextBottomBar(){
    BasicTextFieldView(value = TextFieldValue(text = "请输入内容")){

    }
}

@Composable
fun EditTextView(editTextVIewModel: EditTextViewModel) {
    val editTextUiState  by editTextVIewModel.editTextUiState.collectAsStateWithLifecycle()
    BasicTextFieldView(editTextUiState.textFieldValue) {
        editTextVIewModel.onValueChanged(it)
    }
}


// https://juejin.cn/post/6998038393003180046
// https://developer.android.com/jetpack/compose/text?hl=zh-cn
