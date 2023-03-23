package com.x.compose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.x.compose.R
import com.x.compose.mian.ui.BaseBackToolbar
import com.x.compose.mian.ui.base.BaseScaffoldPage

@Composable
fun BaseTextPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            baseText("基础text")
            Spacer(Modifier.background(Color.White))
            baseTextFieldValue("基础text-buildAnnotatedString")
            baseText("baseTextFiled输入框 ：")
            baseTextFiled()
            baseText("baseBasicTextFiled输入框 ：")
            baseBasicTextFiled()
        }
    }

}