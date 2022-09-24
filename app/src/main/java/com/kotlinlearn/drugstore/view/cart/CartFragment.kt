package com.kotlinlearn.drugstore.view.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentCartBinding
import com.kotlinlearn.drugstore.model.CardProduct

class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    var arrCards  = ArrayList<CardProduct>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewCardProduct()
    }

    private fun initViewCardProduct() {
        binding.reycleOfCard.layoutManager = LinearLayoutManager(context)
        addItemInCard()
        var adapterOrders = MyAdapterCardProduct(arrCards)
        binding.reycleOfCard.adapter =adapterOrders
    }

    private fun addItemInCard() {

        arrCards.add(CardProduct(R.drawable.photo_vitamins_minerals,25,"Name"))
        arrCards.add(CardProduct(R.drawable.photo_vitamins_minerals,25,"Name"))
        arrCards.add(CardProduct(R.drawable.photo_vitamins_minerals,25,"Name"))
        arrCards.add(CardProduct(R.drawable.photo_vitamins_minerals,25,"Name"))

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}