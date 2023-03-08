package com.x.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.x.compose.text.preBasicText

class MainActivity : AppCompatActivity() {


    private val vm: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            preBasicText(vm)
            UserInfoView(vm)
        }
    }

}