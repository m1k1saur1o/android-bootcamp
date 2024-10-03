package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.ProductState

class CartViewModel : ViewModel() {
    var cartList by mutableStateOf(listOf<ProductState>())
        private set

    var totalCost by mutableStateOf(0)
        private set

    init {
        updateTotalCost()
    }

    fun addToCart(
        product: ProductState
    ) {
        val newProduct = product.copy(
            id = cartList.size + (System.currentTimeMillis() / 1000).toInt()
        )
        cartList += newProduct
        updateTotalCost()
    }

    private fun removeFromCart(
        id: Int
    ) {
        cartList = cartList.filter { it.id != id }
    }

    fun clearCart()
    {
        cartList = emptyList()
        updateTotalCost()
    }

    fun addQuantity(
        id: Int
    ) {
        val index = cartList.indexOfFirst { it.id == id }
        val updatedProduct = cartList[index].copy(quantity = cartList[index].quantity + 1)
        cartList = cartList.toMutableList().apply {
            this[index] = updatedProduct
        }
    }

    fun removeQuantity(
        id: Int
    ) {
        val index = cartList.indexOfFirst { it.id == id }
        val updatedProduct = cartList[index].copy(quantity = cartList[index].quantity - 1)
        cartList = cartList.toMutableList().apply {
            this[index] = updatedProduct
        }

        if (cartList[index].quantity == 0) {
            removeFromCart(index)
        }
    }

    fun updateTotalCost(){
        var sum = 0
        cartList.forEach { item ->
            sum += item.quantity * item.price.first
        }
        totalCost = sum
    }
}