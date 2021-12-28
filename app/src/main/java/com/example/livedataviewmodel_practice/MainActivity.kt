package com.example.livedataviewmodel_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.livedataviewmodel_practice.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textDisplay = findViewById<TextView>(R.id.tv_textview)
        val buttonAdd = findViewById<Button>(R.id.btn_add)
        val buttonSubtract = findViewById<Button>(R.id.btn_subtract)
        val btnSecondActivity = findViewById<Button>(R.id.second_activity)


        //initialize the view model using ViewModel provider
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        textDisplay.text = viewModel.number.toString()

        buttonAdd.setOnClickListener {
        viewModel.addNumber()//increments the number variable in the view model
            textDisplay.text = viewModel.number.toString()//displays the number on the ui
        }

        buttonSubtract.setOnClickListener {
            viewModel.subtractNumber() //decrements the number variable in the view model
            textDisplay.text = viewModel.number.toString()
        }

        btnSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}