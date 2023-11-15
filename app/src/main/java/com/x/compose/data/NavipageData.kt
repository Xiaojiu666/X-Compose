package com.x.compose.data

import com.x.compose.R
import com.x.compose.navigation.NAV_HOME_ANIMATED
import com.x.compose.navigation.NAV_HOME_GUEST
import com.x.compose.navigation.NAV_HOME_IMAGE
import com.x.compose.navigation.NAV_HOME_IMAGE_CUSTOM
import com.x.compose.navigation.NAV_HOME_IMAGE_VIEW
import com.x.compose.navigation.NAV_HOME_TEXT
import com.x.compose.navigation.NAV_HOME_TEXT_FIELD


data class HomeNavigateItem(
    val icon: Int = -1, val navigate: String, val name: String, val desc: String
)

fun createHomePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_TEXT,
            "文字",
            "TextView"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_TEXT_FIELD,
            "输入文字",
            "EditText"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_IMAGE_VIEW,
            "图片",
            "ImageView、AsyncImageView"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_IMAGE_CUSTOM,
            "Canvas",
            "Canvas 画布"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_ANIMATED,
            "动画",
            "各种炫酷的动画"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_GUEST,
            "轻触和输入",
            "手势滑动、拖拽"
        ),
    )
}
