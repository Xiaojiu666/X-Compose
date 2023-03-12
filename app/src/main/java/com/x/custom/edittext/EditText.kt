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
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.x.compose.R
import com.x.custom.EditTextViewModel
import keyboardAsState


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
    }
}


@Composable
fun EditTextBottomBar() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (content, bottomView) = createRefs()
        BasicTextFieldView(value = TextFieldValue(text = "请输入内容")) {

        }

        Box(
            modifier = Modifier
                .constrainAs(bottomView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .align(Alignment.BottomCenter)
                    .height(30.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .height(30.dp)
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.icon_text_bold),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.mipmap.icon_text),
                        contentDescription = ""
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun EditTextView() {
    ConstraintLayout(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val (content, bottomView) = createRefs()
        BasicTextField(
            modifier = Modifier.constrainAs(content) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(bottomView.top)
                height = Dimension.fillToConstraints
            }.background(color = Color.Red)
                .fillMaxWidth().fillMaxHeight(),
            value = "value",
            onValueChange = { },
            cursorBrush = SolidColor(Color.Gray),
            decorationBox = {
                it()
            })

        BottomStyleSelector(modifier = Modifier.constrainAs(bottomView) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })

//        Column(
//            modifier = Modifier
//                .constrainAs(bottomView) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    bottom.linkTo(parent.bottom)
//                }
//                .fillMaxWidth()
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding()
//                    .background(Color.White)
//                    .height(30.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .horizontalScroll(rememberScrollState())
//                        .height(30.dp)
//                ) {
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.drawable.icon_text_bold),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                    Image(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(R.mipmap.icon_text),
//                        contentDescription = ""
//                    )
//                }
//            }
//
//            if (isKeyboardOpen == Keyboard.Closed) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                        .navigationBarsPadding()
//                )
//            } else {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                )
//            }
//        }
    }
}

@Composable
fun BottomStyleSelector(modifier: Modifier) {

    val isKeyboardOpen by keyboardAsState()

    Column(
        modifier = Modifier
            .then(modifier)

            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding()
                .background(Color.White)
                .height(30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .height(30.dp)
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.drawable.icon_text_bold),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.mipmap.icon_text),
                    contentDescription = ""
                )
            }
        }

        if (isKeyboardOpen == Keyboard.Closed) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .navigationBarsPadding()
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            )
        }
    }
}


// https://juejin.cn/post/6998038393003180046
// https://developer.android.com/jetpack/compose/text?hl=zh-cn
