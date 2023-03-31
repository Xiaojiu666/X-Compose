package com.x.compose.data

import com.x.compose.R
import com.x.compose.main.navigation.HOME_NAVIGATION_BASE


data class HomeNavigateItem(
    val icon: Int = -1, val navigate: String, val name: String, val desc: String
)

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

fun createBasePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(
            R.mipmap.ic_logo, HOME_NAVIGATION_BASE,
            "Text",
            "一些文本样式"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "Image",
            "一些Image样式"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            HOME_NAVIGATION_BASE,
            "EditText",
            "一些EditText样式"
        ),
    )
}