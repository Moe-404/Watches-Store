package com.mohamed.watchesstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.watchesstore.R
import com.example.watchesstore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        binding.next.setOnClickListener{ view: View ->
            view.findNavController().navigate(
                R.id.action_welcomeScreenFragment2_to_instructionsFragment2)
        }
        return binding.root
    }
}