package com.mohamed.watchesstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.watchesstore.R
import com.example.watchesstore.databinding.FragmentAddItemBinding
import com.mohamed.watchesstore.model.Watch
import com.mohamed.watchesstore.viewModel.WatchesViewModel

class AddItemFragment : Fragment() {
    private lateinit var binding: FragmentAddItemBinding
    private lateinit var viewModelData: WatchesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(inflater, container, false)

        binding.details = Watch()

        viewModelData = ViewModelProvider(requireActivity())[WatchesViewModel::class.java]

        binding.save.setOnClickListener { view: View ->
            saveDetails()
        }

        binding.cancel.setOnClickListener { view: View ->
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun saveDetails() {
        val bindingData = binding.details
        val name = bindingData?.name.toString()
        val color = bindingData?.color.toString()
        val company = bindingData?.company.toString()
        val description = bindingData?.description.toString()


        if (name.isEmpty() || color.isEmpty() || company.isEmpty() || description.isEmpty()) {

            Toast.makeText(context, "Please Fill The Empty Fields", Toast.LENGTH_SHORT).show()
        } else {
            viewModelData.save("Name: $name", "Company: $company", "Color: $color", "Description: $description")

            findNavController().navigate(R.id.action_addItemFragment2_to_watchesListFragment2)
            Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()
        }
    }
}