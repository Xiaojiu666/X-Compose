package com.x.compose.remember

import android.os.Bundle
import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*

data class UserInfo(var name: String, var age: Int)

object UserInfoSaver : Saver<UserInfo, Bundle> {
    override fun restore(value: Bundle): UserInfo {
        return UserInfo(
            value.getString("name") ?: "Old Name",
            value.getInt("age")
        )
    }

    override fun SaverScope.save(value: UserInfo): Bundle {
        return Bundle().apply {
            putString("name", value.name)
            putInt("age", value.age)
        }
    }
}

@Composable
fun Counter() {
    var userInfo = rememberSaveable(saver = UserInfoSaver) { UserInfo("你好呀", 10) }
    Button(onClick = {
        userInfo.name = "不好"
        userInfo.age = userInfo.age + 1
        Log.e("Counter ", userInfo.toString())
    }) {
        if (userInfo.toString().isNotEmpty()) {
            Text("userInfo ${userInfo.toString()}")
        }
    }
}