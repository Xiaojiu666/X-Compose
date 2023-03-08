package com.x.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun UserInfoView(userViewModel: UserViewModel) {

    val uiStateWrapper by userViewModel.userInfo.collectAsStateWithLifecycle()

    Row {
        Text(text = "My sex ${uiStateWrapper.sex}")

        Text(text = "My Name ${uiStateWrapper.name}")

        Text(text = "My Age ${uiStateWrapper.age}")

        Button(onClick = { userViewModel.update() }) {

        }
    }
}