package com.example.livedataviewmodel_practice.viewmodels

import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {

    var number = 0
    fun addNumber(){
        number++
    }

    fun subtractNumber(){
        number --
    }

    override fun onCleared() {
        super.onCleared()
    }
}