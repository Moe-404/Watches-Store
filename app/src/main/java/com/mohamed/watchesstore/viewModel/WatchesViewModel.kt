package com.mohamed.watchesstore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamed.watchesstore.model.Watch

class WatchesViewModel: ViewModel() {
    private var watchesList = mutableListOf<Watch>()

    private var _watches = MutableLiveData<List<Watch>>()
    val watches: LiveData<List<Watch>> get() = _watches

    fun save(name: String ,color:String ,company: String,description: String){
        val newItem = Watch(name,color,company,description)
        newItem.let{item ->
            watchesList.add(item)
            _watches.value = watchesList
        }
    }
}