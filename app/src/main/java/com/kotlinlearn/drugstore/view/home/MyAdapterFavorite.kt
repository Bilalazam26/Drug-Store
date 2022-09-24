package com.kotlinlearn.drugstore.view.home

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.model.MyFavoriteItem

class MyAdapterFavorite(val list_favorite:ArrayList<MyFavoriteItem>):RecyclerView.Adapter<MyAdapterFavorite.myViewHolderfavorite>()  {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolderfavorite {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_my_favorite,parent,false)
        context = parent.context
        return myViewHolderfavorite(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolderfavorite, position: Int) {
        var  current = list_favorite[position]
        holder.tvName.text =current.name
        holder.tvDescription.text =current.description
        holder.imgFavorite.setImageResource(current.img)

        holder.btnRemove.setOnClickListener {

            makeDialog(position)

        }
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




    class myViewHolderfavorite(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        var tvName :TextView = itemView.findViewById(R.id.row_favorite_tv_name)
        var tvDescription :TextView = itemView.findViewById(R.id.row_favorite_tn_description)
        var imgFavorite :ImageView = itemView.findViewById(R.id.row_Order_img)
        var btnRemove :Button = itemView.findViewById(R.id.btn_row_remove_fa)

    }


}