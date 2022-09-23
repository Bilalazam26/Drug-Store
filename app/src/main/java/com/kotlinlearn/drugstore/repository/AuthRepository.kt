package com.kotlinlearn.drugstore.repository

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.kotlinlearn.drugstore.HomeActivity

class AuthRepository(application: Application) {
    private var application: Application
    var userMutableLiveData:MutableLiveData<FirebaseUser>
    var loggedOutMutableLiveData:MutableLiveData<Boolean>
    private var myAuth: FirebaseAuth
    init {
        this.application = application
        this.userMutableLiveData = MutableLiveData()
        this.loggedOutMutableLiveData = MutableLiveData()
        myAuth = FirebaseAuth.getInstance()
    }

    fun register(email : String, password : String) {
        myAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    userMutableLiveData.postValue(myAuth.currentUser)
                } else {
                    Toast.makeText(application, "Registeration failed!${it.exception?.message.toString()}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    fun login(email:String, password:String) {
        if (!(email.isNullOrEmpty() || password.isNullOrEmpty())) {
            myAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                it?.let {
                    userMutableLiveData.postValue(myAuth.currentUser)
                }
            }.addOnFailureListener {
                Toast.makeText(application, "${it.toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun logOut() {
        myAuth.signOut()
        loggedOutMutableLiveData.postValue(true)
    }

}