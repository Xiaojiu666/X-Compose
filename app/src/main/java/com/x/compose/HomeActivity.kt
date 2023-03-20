package com.x.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageView(createHomePageNavigate())
        }
    }
}

fun createHomePageNavigate():List<HomeNavigateItem>{
     return listOf(HomeNavigateItem(R.mipmap.ic_launcher,""))
}


data class HomeNavigateItem(val icon:Int,val navigate: String)