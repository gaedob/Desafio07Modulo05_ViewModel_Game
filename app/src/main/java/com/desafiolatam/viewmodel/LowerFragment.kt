package com.desafiolatam.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.FragmentLowerBinding


class LowerFragment : Fragment() {


    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLowerBinding



            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLowerBinding.inflate(layoutInflater, container, false)
        lifecycleScope.launchWhenCreated {
            viewModel.lowerCounterStateFlow.collect {
                binding.tvLowerCounter.text = it.toString()
            }
        }
        binding.tvLowerClick.setOnClickListener {
            if (viewModel.increaseLower())
                binding.tvLowerClick.text = "You Win..!!"
        }
                viewModel.textViewText.observe(viewLifecycleOwner) { newText ->
                    view?.findViewById<TextView>(R.id.tv_lower_click)?.text = newText
                }

                return binding.root
    }




}