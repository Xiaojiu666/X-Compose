package com.x.compose.mian.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.x.compose.HomePageView
import com.x.compose.createHomePageNavigate
import com.x.compose.text.baseText

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigate() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = HOME_NAVIGATION
    ) {
        navigation(startDestination = HOME_NAVIGATION_DEFAULT, route = HOME_NAVIGATION) {
            composable(
                HOME_NAVIGATION_DEFAULT
            ) {
                HomePageView(homeItem = createHomePageNavigate()) {
                    navController.navigate(it.navigate)
                }
            }
            baseGraph(navController)
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.baseGraph(navController: NavController) {
    navigation(startDestination = "base/text", route = "base") {
        composable(
           route =  BASE_NAVIGATION_TEXT
        ) {
            baseText("你好")
        }
    }
}


fun NavGraphBuilder.animationGraph(navController: NavController) {
    navigation(startDestination = "username", route = "login") {

    }
}
