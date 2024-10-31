package com.desafiolatam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _isActive = MutableStateFlow(false)
    private val upperCounterMutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(10)
    private val lowerCounterMutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(10)

    val upperCounterStateFlow: StateFlow<Int> = upperCounterMutableStateFlow.asStateFlow()
    val lowerCounterStateFlow: StateFlow<Int> = lowerCounterMutableStateFlow.asStateFlow()

    val isActive: StateFlow<Boolean> = _isActive


    val textViewText = MutableLiveData<String>()

    fun setActive(active: Boolean) {
        _isActive.value = active
    }

    fun increaseUpper() : Boolean {

        if (upperCounterMutableStateFlow.value > 0 && lowerCounterMutableStateFlow.value > 0) {
            upperCounterMutableStateFlow.value += 1
            lowerCounterMutableStateFlow.value -= 1
        }

        if (upperCounterMutableStateFlow.value == 20)
            return true
        else
            return  false

    }

    fun increaseLower() : Boolean {
        if (upperCounterMutableStateFlow.value > 0 && lowerCounterMutableStateFlow.value > 0) {
            lowerCounterMutableStateFlow.value += 1
            upperCounterMutableStateFlow.value -= 1
        }

        if (lowerCounterMutableStateFlow.value == 20)
            return true
        else
            return  false
    }
    // Función para actualizar el estado
    fun toggleActive() {
        _isActive.value = !_isActive.value
        resetScores()
    }

    fun resetScores() {

        upperCounterMutableStateFlow.value = 10
        lowerCounterMutableStateFlow.value = 10

    }

    fun isGameFinished(): Boolean {
        return upperCounterMutableStateFlow.value == 0 || lowerCounterMutableStateFlow.value == 0
    }


}