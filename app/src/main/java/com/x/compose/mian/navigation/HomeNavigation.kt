package com.x.compose.mian.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.x.compose.mian.ui.HomePageView
import com.x.compose.createHomePageNavigate
import com.x.compose.text.BaseTextPage
import com.x.compose.text.baseText

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigate() {
    val navController = rememberAnimatedNavController()
    //https://zhuanlan.zhihu.com/p/408075436
    AnimatedNavHost(
        navController = navController,
        startDestination = HOME_NAVIGATION,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it })
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it })
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        }
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
    navigation(startDestination = "a", route = "b") {
        composable(
            route = HOME_NAVIGATION_BASE
        ) {
            BaseTextPage {
                navController.popBackStack()
            }
        }
    }
}


fun NavGraphBuilder.animationViewGraph(navController: NavController) {
    navigation(startDestination = "username", route = "login") {

    }
}
