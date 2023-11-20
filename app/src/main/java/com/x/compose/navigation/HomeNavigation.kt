package com.x.compose.navigation

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
import com.x.compose.animate.AnimatePage
import com.x.compose.animate.state.AnimatedStatePage
import com.x.compose.animate.visibility.AnimatedContentPage
import com.x.compose.animate.visibility.AnimatedVisibilityPage
import com.x.compose.canvas.CanvasPage
import com.x.compose.customize.CustomizePage
import com.x.compose.customize.lotto.LottoPage
import com.x.compose.data.createAnimatePageNavigate
import com.x.compose.data.createCustomizePageNavigate
import com.x.compose.data.createHomePageNavigate
import com.x.compose.home.HomePage
import com.x.compose.image.ImagePage
import com.x.compose.text.BaseTextPage
import com.x.compose.textfiled.TextFieldPage


const val HOME_NAVIGATION = "home"

const val HOME_NAVIGATION_START = "home/start"

const val NAV_HOME_TEXT = "home/text"

const val NAV_HOME_TEXT_FIELD = "home/text/field"


const val NAV_HOME_IMAGE_VIEW = "home/image/imageview"

const val NAV_HOME_IMAGE_CUSTOM = "home/image/custom"


const val NAV_HOME_GUEST = "home/text/guest"

const val NAV_HOME_CUSTOMIZE = "home/customize"

const val NAV_HOME_CUSTOMIZE_LOTTO = "home/customize/lotto"

const val NAV_HOME_ANIMATE = "home/animate"

const val NAV_HOME_ANIMATE_VISIBILITY = "home/animate/animated-visibility"

const val NAV_HOME_ANIMATE_ANIMATE_STATE = "home/animate/animate-asState"

const val NAV_HOME_ANIMATE_CONTENT = "home/animate/content"

const val NAV_HOME_ANIMATE_CROSS_FADE = "home/animate/cross-fade"

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
                HomePage(homeItem = createHomePageNavigate()) {
                    navController.navigate(it.navigate)
                }
            }
            baseGraph(navController)

            customize(navController)

            animate(navController)
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.baseGraph(navController: NavController) {
    navigation(startDestination = "a", route = "b") {
        composable(
            route = NAV_HOME_TEXT
        ) {
            BaseTextPage {
                navController.popBackStack()
            }
        }

        composable(
            route = NAV_HOME_TEXT_FIELD
        ) {
            TextFieldPage {
                navController.popBackStack()
            }
        }


        composable(
            route = NAV_HOME_TEXT_FIELD
        ) {
            TextFieldPage {
                navController.popBackStack()
            }
        }

        composable(
            route = NAV_HOME_IMAGE_VIEW
        ) {
            ImagePage {
                navController.popBackStack()
            }
        }

        composable(
            route = NAV_HOME_IMAGE_CUSTOM
        ) {
            CanvasPage {
                navController.popBackStack()
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.customize(navController: NavController) {
    composable(
        route = NAV_HOME_CUSTOMIZE
    ) {
        CustomizePage(createCustomizePageNavigate(), onItemClick = {
            navController.navigate(it.navigate)
        }) {
            navController.popBackStack()
        }
    }

    composable(
        route = NAV_HOME_CUSTOMIZE_LOTTO
    ) {
        LottoPage {
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.animate(navController: NavController) {
    composable(
        route = NAV_HOME_ANIMATE
    ) {
        AnimatePage(createAnimatePageNavigate(), onItemClick = {
            navController.navigate(it.navigate)
        }) {
            navController.popBackStack()
        }
    }

    composable(
        route = NAV_HOME_ANIMATE_ANIMATE_STATE
    ) {
        AnimatedStatePage {
            navController.popBackStack()
        }
    }

    composable(
        route = NAV_HOME_ANIMATE_VISIBILITY
    ) {
        AnimatedVisibilityPage {
            navController.popBackStack()
        }
    }
    composable(
        route = NAV_HOME_ANIMATE_CONTENT
    ) {
        AnimatedContentPage {
            navController.popBackStack()
        }
    }
}
