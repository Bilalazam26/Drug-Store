package com.kotlinlearn.drugstore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdminProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "1 - appBar containning (about us, log out).\n" +
                "2 - profile image\n" +
                "3 - user data\n" +
                "4 - update button"
    }
    val text: LiveData<String> = _text
}