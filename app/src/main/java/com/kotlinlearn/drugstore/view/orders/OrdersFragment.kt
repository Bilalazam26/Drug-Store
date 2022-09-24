package com.kotlinlearn.drugstore.view.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentOrdersBinding
import com.kotlinlearn.drugstore.model.MyOrder


class OrdersFragment : Fragment() {
    lateinit var binding: FragmentOrdersBinding
    var arrOrders  = ArrayList<MyOrder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewOrders()
    }

    private fun initViewOrders() {
        binding.reycleOfOrder.layoutManager = LinearLayoutManager(context)
        addItemInOrders()
        var adapterOrders = MyAdapterOrder(arrOrders)
        binding.reycleOfOrder.adapter =adapterOrders

    }

    private fun addItemInOrders() {
        arrOrders.add(MyOrder(R.drawable.photo_vitamins_minerals,"Name","Desription"))
        arrOrders.add(MyOrder(R.drawable.photo_vitamins_minerals,"Name","Desription"))
        arrOrders.add(MyOrder(R.drawable.photo_vitamins_minerals,"Name","Desription"))
        arrOrders.add(MyOrder(R.drawable.photo_vitamins_minerals,"Name","Desription"))
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrdersFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}