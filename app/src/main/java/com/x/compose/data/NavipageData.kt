package com.x.compose.data

import com.x.compose.R
import com.x.compose.navigation.HOME_NAVIGATION_BASE


data class HomeNavigateItem(
    val icon: Int = -1, val navigate: String, val name: String, val desc: String
)

fun createHomePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(
            R.mipmap.ic_logo, HOME_NAVIGATION_BASE,
            "文字",
            "TextView,EditText"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "图片和图形",
            "ImageView"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "动画",
            "各种炫酷的动画"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "轻触和输入",
            "手势滑动、拖拽"
        ),
    )
}
