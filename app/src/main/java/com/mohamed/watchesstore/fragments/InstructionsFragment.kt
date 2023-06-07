package com.mohamed.watchesstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.watchesstore.R
import com.example.watchesstore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var bindingUtil: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        binding.start.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_instructionsFragment2_to_watchesListFragment2)
        }
        return binding.root
    }
}