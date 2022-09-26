package com.kotlinlearn.drugstore.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.FragmentHomeBinding
import com.kotlinlearn.drugstore.model.MyCategory
import com.kotlinlearn.drugstore.model.MyFavoriteItem

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var arr_Favorite = ArrayList<MyFavoriteItem>()
    var arr_Category = ArrayList<MyCategory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        initViewCategory()
        initviewFavorite()

    }

    private fun initviewFavorite() {
        binding.recycleMyFavorite.layoutManager = LinearLayoutManager(context)
        addItemInFavorite()
        var adapter = MyAdapterFavorite(arr_Favorite)
        binding.recycleMyFavorite.adapter = adapter

    }

    private fun addItemInFavorite(){
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_vitamins_minerals,"Product Name","Description Of Product "))
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_skincare,"Sponge Bob","pla pla pla pla pla pla  pla pla pla  pla pla pla  pla pla pla "))
        arr_Favorite.add(MyFavoriteItem(R.drawable.photo_haircare,"Sponge Bob","pla pla pla pla pla pla  pla pla pla  pla pla pla  pla pla pla "))
    }

    private fun initViewCategory() {


        binding.recycleCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        addItemCategory()
        var adapter = MyAdapterCategory(arr_Category)
        binding.recycleCategory.adapter = adapter
    }
    private fun addItemCategory(){
        //arr_Category.add(MyCategory(R.drawable.photo_vitamins_minerals, "Vitamins & minerals"))
        arr_Category.add(MyCategory(R.drawable.photo_haircare, "Hair care "))
        arr_Category.add(MyCategory(R.drawable.photo_mom_baby, " Mom & baby"))
        arr_Category.add(MyCategory(R.drawable.photo_skincare, " Skin care"))

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}