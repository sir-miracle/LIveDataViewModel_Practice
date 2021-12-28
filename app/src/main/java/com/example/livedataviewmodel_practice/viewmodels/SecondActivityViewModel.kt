package com.example.livedataviewmodel_practice.viewmodels

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.reflect.Array.get

class SecondActivityViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer
    var timerValue = MutableLiveData<Long>()

    var finished = MutableLiveData<Boolean>()

    private val _seconds = MutableLiveData<Int>()

    val second: LiveData<Int> get() = _seconds //this variable is doing same job as the function seconds()

    fun seconds(): LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        timer = object: CountDownTimer(timerValue.value!!.toLong(), 1000){

            override fun onTick(millisUntilFinished: Long) {
               val timeLeft =  millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()

            }

            override fun onFinish() {
                finished.value = true
            }

        }.start()

    }

    fun stopTimer(){
        timer.cancel()
    }
}