package com.x.compose

import KeyboardHandler
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.x.TestView
import com.x.compose.remember.Counter
import com.x.compose.text.preBasicText
import com.x.custom.EditTextViewModel
import com.x.custom.edittext.EditTextView

class MainActivity : ComponentActivity() {


    private val vm: UserViewModel by viewModels()

    private val editTextViewModel: EditTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            preBasicText()
//            UserInfoView(vm)
//            EditTextView()
//            TestView()
            Counter()
        }
//        KeyboardHandler(findViewById(android.R.id.content)).handleKeyboard()
//        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

}