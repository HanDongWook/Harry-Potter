package com.dongwook.core_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.plus

open class BaseViewModel(
    coroutineExceptionHandler: CoroutineExceptionHandler
): ViewModel() {
    val viewModelErrorHandlingScope: CoroutineScope
        = viewModelScope + coroutineExceptionHandler
}