package com.x.compose

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class UserViewModel : ViewModel() {
    var _userInfo = MutableStateFlow(UserInfo("1", 1, "男人"))

    val userInfo = _userInfo.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        UserInfo("1", 1, "男人")
    )

    fun update() {
        viewModelScope.launch {
            var userInfo = _userInfo.value
            _userInfo.emit(
                userInfo.copy(
                    name = userInfo.name + 1,
                    age = userInfo.age + 1
                )
            )
        }
    }
}


data class UserInfo(var name: String, var age: Int, var sex: String)