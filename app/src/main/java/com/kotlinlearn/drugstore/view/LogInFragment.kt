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
import com.kotlinlearn.drugstore.databinding.FragmentLogInBinding
import com.kotlinlearn.drugstore.viewModel.AuthenticationViewModel


class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
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
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authenticationViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        authenticationViewModel.userMutableLiveData.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                Toast.makeText(context, "User Logged In Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, HomeActivity::class.java))
            }
        })
        initView()
    }

    private fun initView() {
        binding.loginBtn.setOnClickListener {

            val email = binding.emailLogin.text.toString()
            val password = binding.passwordLogin.text.toString()
            if (!(email.isNullOrEmpty() || password.isNullOrEmpty())) {
                authenticationViewModel.login(email, password)
            } else {
                Toast.makeText(context, "Empty Email or Password is not allowed here", Toast.LENGTH_SHORT).show()
            }
        }

    }





    companion object {
        @JvmStatic
        fun newInstance() =
            LogInFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}