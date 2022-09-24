package com.kotlinlearn.drugstore.view.cart

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kotlinlearn.drugstore.R
import com.kotlinlearn.drugstore.model.CardProduct

class MyAdapterCardProduct(var list: ArrayList<CardProduct>): RecyclerView.Adapter<MyAdapterCardProduct.MYViewHolder>() {


    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_my_cards,parent,false)
         context = parent.context
        return MYViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
      var current = list[position]
        holder.imgCard.setImageResource(current.img)
        holder.tvPriceCard.text= current.price.toString()
        holder.tvCardName.text= current.name

        holder.removeCard.setOnClickListener {
            makeDialog(position)
        }

    }

    override fun getItemCount(): Int {
      return  list.size
    }
   inner class MYViewHolder(item: View):RecyclerView.ViewHolder(item){

        var tvCardName : TextView = itemView.findViewById(R.id.tv_name_card_product)
        var imgCard :ImageView = itemView.findViewById(R.id.img_card)
        var tvPriceCard :TextView = itemView.findViewById(R.id.tvPriceCard)
        var removeCard :ImageView = itemView.findViewById(R.id.card_delet_item)
        var increaseCount :ImageView = itemView.findViewById(R.id.img_plus)
        var decreaseCount :ImageView = itemView.findViewById(R.id.img_mins)
        var countProduct :TextView = itemView.findViewById(R.id.tv_numOfProductCard)



    }






    fun makeDialog(index :Int){
        var bulider = AlertDialog.Builder(context)
        bulider.apply {
            setTitle("Confirmation ")
            setMessage("Are you sure to delete this item ?")
            setIcon(R.drawable.ic_pharmacy_icon_svgrepo_com)
            setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(context, "Deleted Successfully ", Toast.LENGTH_SHORT).show()
                list.remove(list[index])
                notifyDataSetChanged()
            })
            setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

            })

        }
        bulider.create()
        bulider.show()
    }

}