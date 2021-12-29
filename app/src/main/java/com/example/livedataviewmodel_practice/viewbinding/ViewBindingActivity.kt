package com.example.livedataviewmodel_practice.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.livedataviewmodel_practice.R
import com.example.livedataviewmodel_practice.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {
    //first you go to gradle and set your viewBinding to true inside build features
    //the you late initialize your binding
    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        // your content view will now be set to the root of your binding, instead of using R.layout
        setContentView(binding.root)
            //now you can use the binding to access your xml views
        binding.textView.text = "Binding is working"
    }

}