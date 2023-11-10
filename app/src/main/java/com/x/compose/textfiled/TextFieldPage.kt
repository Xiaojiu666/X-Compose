package com.x.compose.textfiled

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.x.compose.R
import com.x.compose.base.ui.BaseBackToolbar
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.text.itemContainer
import com.x.compose.theme.body2
import com.x.compose.theme.colorBackground
import com.x.compose.theme.colorPrimary
import com.x.compose.theme.colorTertiary

@Composable
fun TextFieldPage(onBackClick: () -> Unit) {
    BaseScaffoldPage(modifier = Modifier.background(colorBackground()), toolbar = {
        BaseBackToolbar(title = stringResource(id = R.string.base_page_text)) {
            onBackClick()
        }
    }) {
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            item {
                itemContainer("基础TextField") {
                    BaseTextField()
                }
            }
            item {
                itemContainer("MD TextField") {
                    OutlinedTextFieldSample()
                }
            }

            item {
                itemContainer("keyboardOptions Pw") {
                    PasswordTextField()
                }
            }

            item {
                itemContainer("可搜索的输入框") {
                    CustomerSearchTextField()
                }
            }
        }
    }
}

@Composable
fun BaseTextField() {
    var text by remember { mutableStateOf("Hello") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun OutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomerSearchTextField() {
    var content by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val hint by remember {
        mutableStateOf("请输入一段文字~")
    }
    val (focusRequester) = FocusRequester.createRefs()
    BasicTextField(
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            println("onSearch $content")
        }),
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .padding(16.dp),
        value = content,
        singleLine = true,
        cursorBrush = SolidColor(colorPrimary()),
        onValueChange = {
            content = it
        },
        decorationBox = {
            if (content.text.isEmpty()) {
                Text(
                    text = hint, style = body2 + TextStyle(color = colorTertiary())
                )
            }
            it()
        },
        textStyle = body2 + TextStyle(color = colorTertiary())
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}