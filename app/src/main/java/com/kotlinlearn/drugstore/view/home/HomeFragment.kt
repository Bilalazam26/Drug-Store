package com.kotlinlearn.drugstore.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentHomeBinding
import com.kotlinlearn.drugstore.model.MyCategory
import com.kotlinlearn.drugstore.model.Product
import com.kotlinlearn.drugstore.interfaces.Favourite
import com.kotlinlearn.drugstore.view.products.ProductAdapter
import com.kotlinlearn.drugstore.view.products.ProductsViewModel
import com.kotlinlearn.drugstore.view.profile.ProfileViewModel
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    lateinit var binding: FragmentHomeBinding
    private lateinit var productsViewModel: ProductsViewModel
    private var favouritesList:MutableList<Product> = mutableListOf()
    var arr_Category = ArrayList<MyCategory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.getCurrentUser()
        productsViewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        productsViewModel.getFavourites()
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        initViewCategory()
        viewFavourites()

    }

    private fun viewFavourites() {
        productsViewModel.favouritesMutableLiveData.observe(viewLifecycleOwner, Observer{
            favouritesList.addAll(it)
            initFavouriteRecycler()
        })
    }

    private fun setObservers() {
        profileViewModel.userMutableLiveData.observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.homeUserName.text = "${it.firstName} ${it.lastName}"
                Picasso.get().load(it.image).into(binding.photoProfile)
            }
        })
    }

    private fun initFavouriteRecycler() {
        val layoutManager = GridLayoutManager(context, 2)
        val adapter = ProductAdapter(context, object : Favourite {
            override fun addToFavourites(product: Product) {
                productsViewModel.addToFavourites(product)
            }

            override fun removeFromFavourites(product: Product) {
                productsViewModel.removeFromFavourites(product)
            }

        }, favouritesList)
        binding.recycleMyFavorite.layoutManager = layoutManager
        binding.recycleMyFavorite.adapter = adapter
        adapter.setData(favouritesList)
    }
/*
    private fun addItemInFavorite(){
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_vitamins_minerals,"Product Name","Description Of Product "))
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_skincare,"Sponge Bob","pla pla pla pla pla pla  pla pla pla  pla pla pla  pla pla pla "))
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_haircare,"Sponge Bob","pla pla pla pla pla pla  pla pla pla  pla pla pla  pla pla pla "))
    }
*/
    private fun initViewCategory() {
        binding.recycleCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        addItemCategory()
        var adapter = MyAdapterCategory(arr_Category)
        binding.recycleCategory.adapter = adapter
    }
    private fun addItemCategory(){
        arr_Category.add(MyCategory(R.drawable.photo_vitamins_minerals, "Vitamins and minerals"))
        arr_Category.add(MyCategory(R.drawable.photo_haircare, "Hair care"))
        arr_Category.add(MyCategory(R.drawable.photo_mom_baby, "Mom and baby"))
        arr_Category.add(MyCategory(R.drawable.photo_skincare, "Skin care"))

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}