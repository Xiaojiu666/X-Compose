package com.x.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.x.compose.theme.AppTheme
import com.x.compose.theme.colorPrimary
import com.x.compose.theme.colorSecondary
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageNames = getImageNames(baseContext, "manhua/1")
        val mhGather = getImageNames(baseContext, "manhua")
        setContent {
            AppTheme {
                MHDetails(mhGather)
                //       ImageList(imageNames)
            }
        }
    }
}

@Composable
fun MHDetails(mhGather: List<String>) {
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


@Composable
fun ImageList(imageNames: List<String>) {
    LazyColumn(
        modifier = Modifier.background(Color.White),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageNames) { imageName ->
            println("imageName $imageName")
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("file:///android_asset/manhua/1/$imageName").build(),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
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
