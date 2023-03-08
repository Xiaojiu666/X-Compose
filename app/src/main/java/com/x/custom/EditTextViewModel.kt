package com.x.custom

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x.compose.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EditTextViewModel : ViewModel(){

   private  val _editTextUiState = MutableStateFlow(EditTextUiState(textFieldValue = TextFieldValue(text = "请输入内容")))

    val editTextUiState = _editTextUiState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        EditTextUiState(textFieldValue = TextFieldValue(text = "请输入内容"))
    )

    data class EditTextUiState(val textFieldValue : TextFieldValue)

    fun onValueChanged(textFieldValue : TextFieldValue){
        viewModelScope.launch {
            val editTextUiState = _editTextUiState.value
            _editTextUiState.emit(editTextUiState.copy( textFieldValue = textFieldValue ))
        }
    }

}