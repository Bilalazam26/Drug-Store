package com.kotlinlearn.drugstore.view.checkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kotlinlearn.drugstore.model.Order
import com.kotlinlearn.drugstore.repository.OrderRepository
import com.kotlinlearn.drugstore.repository.ProductsRepository

class OrderViewModel(application: Application) : AndroidViewModel(application) {
    val repository: OrderRepository = OrderRepository(application)

    fun sendOrder(order: Order) {
        repository.sendOrder(order)
    }

}