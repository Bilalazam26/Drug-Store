package com.kotlinlearn.drugstore.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlinlearn.drugstore.HomeActivity
import com.kotlinlearn.drugstore.MainActivity
import com.kotlinlearn.drugstore.databinding.FragmentSignUpBinding
import com.kotlinlearn.drugstore.viewModel.AuthenticationViewModel


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var authenticationViewModel: AuthenticationViewModel
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
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authenticationViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        authenticationViewModel.userMutableLiveData.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                Toast.makeText(context, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, MainActivity::class.java))
            }
        })
        initView()
    }

    private fun initView() {
        binding.btnSignUp.setOnClickListener {
            var email:String = binding.rgisterEmail.text.toString()
            var password:String = binding.registerPassword.text.toString()
            if (!(email.isNullOrEmpty() || password.isNullOrEmpty())) {
                authenticationViewModel.register(email, password)
                startActivity(Intent(context, HomeActivity::class.java))
            } else {
                Toast.makeText(context, "Empty Email or Password is not allowed here", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}