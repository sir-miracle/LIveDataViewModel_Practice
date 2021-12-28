package com.example.livedataviewmodel_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataviewmodel_practice.viewmodels.SecondActivityViewModel

class SecondActivity : AppCompatActivity() {

    lateinit var displayTimer: TextView
    lateinit var start: Button
    lateinit var stop: Button
    lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        displayTimer = findViewById(R.id.textView)
        start = findViewById(R.id.btn_start)
        stop = findViewById(R.id.btn_stop)
        input = findViewById(R.id.input)
        //instantiate the view model using view model provider
         val viewModel = ViewModelProvider(this).get(SecondActivityViewModel::class.java)

        //observe the seconds function from the view model live data
        viewModel.seconds().observe(this, Observer {
            //display the value of what is observed(it) on the ui
            displayTimer.text = it.toString()
        })

        //this will do same this as observing the function seconds()
        viewModel.second.observe(this, Observer {
            Log.d("Second", "$it")
        })

        viewModel.finished.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Count Down Done", Toast.LENGTH_SHORT).show()
            }
        })

        start.setOnClickListener {
            if(input.text.isBlank() || !(input.text.isDigitsOnly())){

                Toast.makeText(this, "Invalid Number", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.timerValue.value = input.text.toString().toLong()
                viewModel.startTimer()
            }
        }

        stop.setOnClickListener {
            displayTimer.text = "0"
            viewModel.stopTimer()
        }
    }
}