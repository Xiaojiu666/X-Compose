package com.x.compose.mian.ui.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x.compose.mian.ui.BaseTitleToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScaffoldPage(
    toolbar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize(),
        topBar = toolbar
    ) {
        content(it)
    }
}