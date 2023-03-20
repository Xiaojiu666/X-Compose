package com.x.compose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import com.x.TestView
import com.x.compose.text.preBasicText
import com.x.custom.EditTextViewModel
import com.x.custom.edittext.EditTextView

class MainActivity : AppCompatActivity() {


    private val vm: UserViewModel by viewModels()

    private val editTextViewModel: EditTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            preBasicText(vm)
//            UserInfoView(vm)
//            EditTextView(editTextViewModel)
            TestView()
        }
    }

}