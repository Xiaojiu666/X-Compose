package com.x.custom.edittext

import androidx.compose.ui.text.input.TextFieldValue

interface UiStateWrapper {

    object Loading : UiStateWrapper

    data class Error(val throwable: Throwable, val message: String?) : UiStateWrapper

}

class EditTextUiState(
    val textFieldValue: TextFieldValue,
    var onValueChange: TextFieldValue,
) : UiStateWrapper



