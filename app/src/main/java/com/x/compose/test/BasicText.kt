package com.x.compose.test

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.LOGTAG


@Composable
fun basicText() {
    Text(
        text = stringResource(R.string.app_name),
        //控制Text外部边框的一些属性，eg: Size Background
        modifier = Modifier.background(Color.Black).padding(10.dp)
            .border(BorderStroke(10.dp, brush = Brush.horizontalGradient())),
        color = Color.White
    )
}

@Composable
fun basicTextFiled() {
    //文本字段
    TextField(
        value = TextFieldValue(stringResource(R.string.app_name)),
        onValueChange = {
            Log.d("basicTextFiled", "it value ${it.text}")
        }
    )
}


@Preview
@Composable
fun preBasicText() {

    basicText()

//    Column(modifier = Modifier.background(Color.Black).fillMaxSize().padding(20.dp)) {
//
//        basicText()
//
//        Spacer(Modifier.background(Color.White))
//
//        basicTextFiled()
//    }
}