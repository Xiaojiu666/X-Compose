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
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
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
    AnimatedNavHost(
        navController = navController,
        startDestination = HOME_NAVIGATION,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
//        enterTransition = {
//            slideIntoContainer(
//                AnimatedContentScope.SlideDirection.Left,
//                animationSpec = tween(300)
//            )
//            scaleIn(
//                animationSpec = tween(700),
//                initialScale = 0.2f,
//                transformOrigin = TransformOrigin(0.2f, 0.2f)
//            )
//        },
//        exitTransition = {
//            slideOutOfContainer(
//                AnimatedContentScope.SlideDirection.Right,
//                animationSpec = tween(300)
//            )
//            scaleOut(
//                animationSpec = tween(700),
//                targetScale = 0.2f,
//                transformOrigin = TransformOrigin(0.2f, 0.2f)
//            )
//        }
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
            route = BASE_NAVIGATION_TEXT
        ) {
            BaseTextPage {
                navController.popBackStack()
            }
        }
    }
}


fun NavGraphBuilder.animationGraph(navController: NavController) {
    navigation(startDestination = "username", route = "login") {

    }
}
