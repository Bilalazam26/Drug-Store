package com.kotlinlearn.drugstore.view.home

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.databinding.ProductLayoutBinding
import com.kotlinlearn.drugstore.model.MyFavoriteItem
import com.kotlinlearn.drugstore.model.Product

class MyAdapterFavorite(val list_favorite:ArrayList<Product>):RecyclerView.Adapter<MyAdapterFavorite.myViewHolderfavorite>()  {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolderfavorite {
        val binding = ProductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        context = parent.context
        return myViewHolderfavorite(binding)
    }

    override fun onBindViewHolder(holder: myViewHolderfavorite, position: Int) {
        var  current = list_favorite[position]

    }

    override fun getItemCount(): Int {
      return list_favorite.size
    }

    fun makeDialog(index :Int){
        var bulider = AlertDialog.Builder(context)
         bulider.apply {
             setTitle("Confirmation ")
             setMessage("Are you sure to delete this item ?")
             setIcon(R.drawable.ic_pharmacy_icon_svgrepo_com)
             setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                 Toast.makeText(context, "Deleted Successfully ", Toast.LENGTH_SHORT).show()
                 list_favorite.remove(list_favorite[index])
                 notifyDataSetChanged()
             })
             setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->

             })

         }
        bulider.create()
        bulider.show()
    }




    class myViewHolderfavorite(itemView : ProductLayoutBinding) : RecyclerView.ViewHolder(itemView.root)
    {
        var productImage : ImageView = itemView.productImage
        var productName : TextView = itemView.productName
        var productPrice : TextView = itemView.productPrice
        var isFav : CheckBox = itemView.favouriteChb

    }


}