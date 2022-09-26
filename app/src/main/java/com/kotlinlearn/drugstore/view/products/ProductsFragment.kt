package com.kotlinlearn.drugstore.view.products

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentProductsBinding
import com.kotlinlearn.drugstore.model.Product

class ProductsFragment : Fragment() {
    private lateinit var binding:FragmentProductsBinding
    private lateinit var category:String

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
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category = staticCategory
        setListeners()
        initView()
    }



    private fun initView() {
        binding.categoryName.text = category
        getProducts()
    }

    private fun setProductsRecyclerView(products: MutableList<Product>) {
        val layoutManager = GridLayoutManager(context, 2)
        val adapter = ProductAdapter(context)
        binding.productsRecyclerView.layoutManager = layoutManager
        binding.productsRecyclerView.adapter = adapter
        adapter.setData(products)
    }

    private fun getProducts(){
        var products = mutableListOf<Product>()
        FirebaseDatabase.getInstance().reference.child("Hair care").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for ( child in snapshot.children){
                    products.add(child.getValue(Product::class.java) as Product)

                }
                setProductsRecyclerView(products)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setListeners() {
        binding.backBtn.setOnClickListener {

        }
        binding.homeBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_productsFragment_to_navigation_home)
        }
    }

    companion object {
        lateinit var staticCategory:String

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {

                }
            }

        fun getCategory(tv: String) {
            staticCategory = tv
        }
    }
}