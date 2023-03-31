package com.x.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.annotation.IntegerRes
import androidx.annotation.RawRes
import com.x.compose.mian.navigation.HOME_NAVIGATION_BASE
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
        HomeNavigateItem(
            R.mipmap.ic_logo, HOME_NAVIGATION_BASE,
            "基础控件",
            "TextView,ImageView,EditText"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "容器控件",
            "Column、Row、Box、List"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "动画效果",
            "TextView、ImageView、EditText"
        ),
    )
}


data class HomeNavigateItem(
    val icon: Int, val navigate: String, val name: String, val desc: String
)