package com.kotlinlearn.drugstore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdminOrdersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "1 - recycler view of all previous orders."
    }
    val text: LiveData<String> = _text
}