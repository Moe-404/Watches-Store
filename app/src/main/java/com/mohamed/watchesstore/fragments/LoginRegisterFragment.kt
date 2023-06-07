package com.mohamed.watchesstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.watchesstore.R
import com.example.watchesstore.databinding.FragmentLoginRegisterBinding

class LoginRegisterFragment : Fragment() {
    private lateinit var binding:FragmentLoginRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentLoginRegisterBinding.inflate(inflater,container,false)
        binding.login.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_loginRegisterFragment2_to_welcomeScreenFragment2)

        }
        binding.register.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_loginRegisterFragment2_to_welcomeScreenFragment2)
        }
        return binding.root
    }
}