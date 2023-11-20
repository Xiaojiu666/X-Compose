package com.x.compose.data

import com.x.compose.R
import com.x.compose.navigation.NAV_HOME_ANIMATE
import com.x.compose.navigation.NAV_HOME_ANIMATE_ANIMATE_STATE
import com.x.compose.navigation.NAV_HOME_ANIMATE_CONTENT
import com.x.compose.navigation.NAV_HOME_ANIMATE_CROSS_FADE
import com.x.compose.navigation.NAV_HOME_ANIMATE_VISIBILITY
import com.x.compose.navigation.NAV_HOME_CUSTOMIZE
import com.x.compose.navigation.NAV_HOME_CUSTOMIZE_LOTTO
import com.x.compose.navigation.NAV_HOME_GUEST
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
            NAV_HOME_ANIMATE,
            "动画",
            "各种炫酷的动画"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_GUEST,
            "轻触和输入",
            "手势滑动、拖拽"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_CUSTOMIZE,
            "自定义布局",
            "一些脑洞大开的自定义布局"
        ),
    )
}


fun createCustomizePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_CUSTOMIZE_LOTTO,
            "刮刮乐",
            "沉迷于刮刮乐，自定义图层，仿刮刮乐"
        ),
    )
}

fun createAnimatePageNavigate(): List<HomeNavigateItem> {
    return listOf(
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_ANIMATE_VISIBILITY,
            "AnimatedVisibility",
            "可以为组件的出现和消失添加动画效果"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_ANIMATE_ANIMATE_STATE,
            "animate*AsState",
            "animate*AsState 函数是 Compose 中最简单的动画 API，用于为单个值添加动画效果。" +
                    "例如animateFloatAsState"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_ANIMATE_CROSS_FADE,
            "CrossFade",
            "可使用淡入淡出动画在两个布局之间添加动画效果"
        ),
        HomeNavigateItem(
            R.mipmap.ic_logo,
            NAV_HOME_ANIMATE_CONTENT,
            "AnimateContent",
            "在内容根据目标状态发生变化时，为内容添加动画效果。"
        ),
    )
}