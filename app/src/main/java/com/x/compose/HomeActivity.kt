package com.x.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.annotation.IntegerRes
import androidx.annotation.RawRes
import com.x.compose.mian.navigation.BASE_NAVIGATION_TEXT
import com.x.compose.mian.navigation.HomeNavigate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeNavigate()
        }
    }
}

fun createHomePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(R.mipmap.ic_launcher, BASE_NAVIGATION_TEXT, "基础控件"),
        HomeNavigateItem(R.mipmap.ic_launcher, "", "容器控件"),
        HomeNavigateItem(R.mipmap.ic_launcher, "", "动画"),
    )
}


data class HomeNavigateItem(
    val icon: Int, val navigate: String, val name: String, val desc: String = ""
)