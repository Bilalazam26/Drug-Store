package com.kotlinlearn.drugstore.repository

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.kotlinlearn.drugstore.model.Order
import com.kotlinlearn.drugstore.utils.Constants

class OrderRepository(application: Application) {

    private var reference = FirebaseDatabase.getInstance().reference
    private var authRef = FirebaseAuth.getInstance()


    fun sendOrder(order: Order) {
        reference.child(Constants.OrderPath).child(authRef.currentUser?.uid.toString()).child(order.id).setValue(order)
        cartCleanUp()
    }

    private fun cartCleanUp() {
        reference.child(Constants.CartPath).child(authRef.currentUser?.uid.toString()).child(Constants.CartProductsPath).removeValue()
    }

}