package com.kotlinlearn.drugstore.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlinlearn.drugstore.MainActivity
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentProfileBinding
import com.kotlinlearn.drugstore.viewModel.AuthenticationViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
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
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authenticationViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        authenticationViewModel.loggedOutMutableLiveData.observe(viewLifecycleOwner, Observer{
            if (it){
                startActivity(Intent(context, MainActivity::class.java))
            }
        })
        binding.menuBtn.setOnClickListener {
            val array = resources.getStringArray(R.array.items)
            val builder = AlertDialog.Builder(context as Context)
            builder.setTitle("Select one")
                .setItems(R.array.items){ dialog, position ->
                    when(position) {
                        2 -> {authenticationViewModel.logOut()}
                    }
                }.show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}