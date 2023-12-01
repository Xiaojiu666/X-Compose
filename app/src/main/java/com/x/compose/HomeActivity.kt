package com.x.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.x.compose.base.ui.BaseScaffoldPage
import com.x.compose.base.ui.BaseTitleToolbar
import com.x.compose.navigation.HomeNavigate
import com.x.compose.theme.AppTheme
import com.x.compose.theme.colorBackground
import com.x.compose.theme.colorPrimary
import com.x.compose.theme.colorSecondary
import java.io.IOException

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mhGather = getImageNames(baseContext, "manhua")
        setContent {
            AppTheme {
                HomeNavigate()
//                MHDetails(mhGather)
//                    ImageList(imageNames)
            }
        }
    }
}

@Composable
fun MHReaderPag1e(mhGather: List<String>) {
    BaseScaffoldPage(toolbar = { BaseTitleToolbar(title = stringResource(id = R.string.app_name)) }) {
        Box(
            modifier = Modifier
                .background(colorBackground())
                .padding(it)
                .fillMaxSize()
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                items(mhGather) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(colorPrimary())
                            .padding(4.dp),
                        text = "第 $it 集", color = colorSecondary(), textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun MHDetails(mhGather: List<String>, onGatherClick: (String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(4)) {
        items(mhGather) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .background(colorPrimary())
                    .padding(4.dp)
                    .clickable {
                        onGatherClick(it)
                    },
                text = "第 $it 集", color = colorSecondary(), textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun MHReaderPage(imagePath: List<String>) {
    BaseScaffoldPage(toolbar = { BaseTitleToolbar(title = stringResource(id = R.string.app_name)) }) {
        Box(
            modifier = Modifier
                .background(colorBackground())
                .padding(it)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.background(Color.White),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(imagePath) { imageName ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageName).build(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

private fun getImageNames(context: android.content.Context, folderName: String): List<String> {
    return try {
        context.assets.list(folderName)?.toList()?.sortedBy { it.substringBeforeLast('.').toInt() }
            ?: emptyList()
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}
