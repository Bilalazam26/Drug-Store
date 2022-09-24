package com.kotlinlearn.drugstore.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.model.MyCategory

class MyAdapterCategory (private val list_category:ArrayList<MyCategory>):RecyclerView.Adapter<MyAdapterCategory.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_category,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var currentItem = list_category[position]
        holder.image.setImageResource(currentItem.img)
        holder.tv.text= currentItem.tv


    }

    override fun getItemCount(): Int {
    return list_category.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val image :ImageView =itemView.findViewById(R.id.row_category_img)
        val tv :TextView =itemView.findViewById(R.id.row_category_tv)

    }


}