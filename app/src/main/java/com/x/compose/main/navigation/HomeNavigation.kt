package com.x.compose.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.x.compose.base.BasePageRoute
import com.x.compose.container.TagView
import com.x.compose.data.createHomePageNavigate
import com.x.compose.main.ui.HomePageView
import com.x.compose.text.BaseTextPage

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
        navigation(startDestination = HOME_NAVIGATION_START, route = HOME_NAVIGATION) {
            composable(
                HOME_NAVIGATION_START
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
            BasePageRoute(baseItem = createHomePageNavigate()) {
                navController.navigate(it.navigate)
            }
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
