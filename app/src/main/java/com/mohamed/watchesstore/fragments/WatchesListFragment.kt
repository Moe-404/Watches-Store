package com.mohamed.watchesstore.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.watchesstore.R
import com.example.watchesstore.databinding.FragmentWatchesListBinding
import com.example.watchesstore.databinding.WatchesBinding
import com.mohamed.watchesstore.model.Watch
import com.mohamed.watchesstore.viewModel.WatchesViewModel

@Suppress("DEPRECATION")
class WatchesListFragment : Fragment() {
    private lateinit var binding: FragmentWatchesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentWatchesListBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(requireActivity())[WatchesViewModel::class.java]

        viewModel.watches.observe(viewLifecycleOwner) { item ->
            watchListView(item)
        }

        binding.lifecycleOwner = viewLifecycleOwner
        binding.floatingButton.setOnClickListener{
            view?.let{item -> Navigation.findNavController(item).navigate(R.id.action_watchesListFragment2_to_addItemFragment2)}
        }
        return binding.root
    }

    private fun watchListView(item: List<Watch>?) {
        item?.forEach{
            val bindingView = WatchesBinding.inflate(LayoutInflater.from(requireContext()),binding.watchesList,false)
            with(bindingView){
                Name.text = it.name
                Color.text = it.color
                Company.text = it.company
                Description.text = it.description
            }
            binding.watchesList.addView(bindingView.root)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_watchesListFragment2_to_loginRegisterFragment2)
        return super.onContextItemSelected(item)
    }
}