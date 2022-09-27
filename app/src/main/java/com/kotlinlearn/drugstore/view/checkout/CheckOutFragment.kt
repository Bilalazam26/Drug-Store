package com.kotlinlearn.drugstore.view.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.model.CartItem

class CheckOutFragment : Fragment() {


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
        return inflater.inflate(R.layout.fragment_check_out, container, false)
    }

    companion object {

        var orderTotalAmount : Int = 0
        var orderItems : MutableList<CartItem> = mutableListOf()
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckOutFragment().apply {
                arguments = Bundle().apply {
                }
            }

        fun getCartData(totalAmount : Int,cartItems : MutableList<CartItem>){
            orderItems.addAll(cartItems)
            orderTotalAmount = totalAmount
        }
    }
}