package com.example.livedataviewmodel_practice.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livedataviewmodel_practice.R
import com.example.livedataviewmodel_practice.databinding.FragmentViewBindingBinding


class ViewBindingFragment : Fragment(R.layout.fragment_view_binding) {

    lateinit var binding: FragmentViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //on create View is not needed since the class Fragment takes the layout as an argument

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentViewBindingBinding.bind(view)

        binding.textViewfragment.text = "view binding is working"
    }

}