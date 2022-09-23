package com.kotlinlearn.drugstore.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.kotlinlearn.drugstore.repository.AuthRepository

class AuthenticationViewModel(application: Application ) : AndroidViewModel(application) {
    private var authRepository: AuthRepository
    var userMutableLiveData: MutableLiveData<FirebaseUser>
    var loggedOutMutableLiveData:MutableLiveData<Boolean>

    init {
        authRepository = AuthRepository(application)
        userMutableLiveData = authRepository.userMutableLiveData
        this.loggedOutMutableLiveData = authRepository.loggedOutMutableLiveData
    }

    fun register(email:String, password:String) {
        authRepository.register(email, password)
    }

    fun login(email:String, password:String) {
        authRepository.login(email, password)
    }

    fun logOut() {
        authRepository.logOut()
    }

}