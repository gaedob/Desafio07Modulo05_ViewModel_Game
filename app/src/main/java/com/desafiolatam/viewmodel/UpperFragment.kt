package com.desafiolatam.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.FragmentUpperBinding

class UpperFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentUpperBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpperBinding.inflate(layoutInflater, container, false)
        lifecycleScope.launchWhenCreated {
            viewModel.upperCounterStateFlow.collect {
                binding.tvUpperCounter.text = it.toString()
            }
        }

        binding.tvUpperClick.setOnClickListener {
            if (viewModel.increaseUpper())
            binding.tvUpperClick.text = "You Win..!!"
        }

        viewModel.textViewText.observe(viewLifecycleOwner) { newText ->
            view?.findViewById<TextView>(R.id.tv_upper_click)?.text = newText

        }
        return binding.root
    }
}