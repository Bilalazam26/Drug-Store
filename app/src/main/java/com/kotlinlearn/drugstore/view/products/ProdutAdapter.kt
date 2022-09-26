package com.kotlinlearn.drugstore.view.products

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.ProductLayoutBinding
import com.kotlinlearn.drugstore.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(private val context: Context?) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    private var productsList:MutableList<Product> = mutableListOf<Product>()

    inner class ProductViewHolder(itemView: ProductLayoutBinding): RecyclerView.ViewHolder(itemView.root){
        var productImage : ImageView = itemView.productImage
        var productName : TextView = itemView.productName
        var productPrice : TextView = itemView.productPrice
        var isFav : CheckBox = itemView.favouriteChb
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product = productsList[position]

        Picasso.get().load(product.img).placeholder(R.drawable.profile).into(holder.productImage)
        holder.productName.text = product.pName
        holder.productPrice.text = "${product.price.toString()} L.E"
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun setData(productsList: MutableList<Product>){
        this.productsList.addAll(productsList)
        notifyDataSetChanged() //to notify adapter that new data change has been happened to adapt it
    }
}
