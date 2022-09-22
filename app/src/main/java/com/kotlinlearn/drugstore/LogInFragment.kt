package com.kotlinlearn.drugstore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kotlinlearn.drugstore.databinding.ActivityMainBinding
import com.kotlinlearn.drugstore.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private lateinit var myAuth: FirebaseAuth
    private lateinit var binding: FragmentLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeFirebaseAuth()
        initView()
    }

    private fun initView() {
        binding.loginBtn.setOnClickListener {

            var email = binding.emailLogin.text.toString()
            var password = binding.passwordLogin.text.toString()
            login(email, password)
        }

    }

    private fun initializeFirebaseAuth() {
        myAuth = FirebaseAuth.getInstance()
    }
    fun login(email:String, password:String) {
        myAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            it?.let {
                startActivity(Intent(context, HomeActivity::class.java))
            }
        }.addOnFailureListener {
            Toast.makeText(context, "${it.toString()}", Toast.LENGTH_SHORT).show()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LogInFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}