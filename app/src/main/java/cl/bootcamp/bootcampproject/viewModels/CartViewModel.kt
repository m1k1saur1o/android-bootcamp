package cl.bootcamp.bootcampproject.viewModels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import cl.bootcamp.bootcampproject.model.CartItemState
import cl.bootcamp.bootcampproject.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "cart_database"
    ).build()

    private val _cartList = MutableStateFlow<List<CartItemState>>(emptyList())

    val cartList = _cartList.asStateFlow()

    var totalCost by mutableIntStateOf(0)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().getCartItems().collect { item ->
                _cartList.value = item
                updateTotalCost()
            }
        }
    }

    fun insertCartItem(
        item: CartItemState
    )
    {
        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().insertCartItem(item)
            db.cartItemDao().getCartItems().collect { updatedList ->
                _cartList.value = updatedList
                updateTotalCost()
            }
        }
    }

    private fun deleteCartItem(
        item: CartItemState
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().deleteCartItem(item)
            updateTotalCost()
        }
    }

    fun clearCart()
    {
        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().clearCart()
            _cartList.value = emptyList()
            updateTotalCost()
        }
    }

    fun addQuantity(
        id: Long
    ) {
        val index = _cartList.value.indexOfFirst { it.id == id }
        val updatedProduct = _cartList.value[index].copy(quantity = _cartList.value[index].quantity + 1)
        _cartList.value = _cartList.value.toMutableList().apply {
            this[index] = updatedProduct
        }

        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().updateCartItem(updatedProduct)
        }
    }

    fun removeQuantity(
        id: Long
    ) {
        val index = _cartList.value.indexOfFirst { it.id == id }
        val updatedProduct = _cartList.value[index].copy(quantity = _cartList.value[index].quantity - 1)
        _cartList.value = _cartList.value.toMutableList().apply {
            this[index] = updatedProduct
        }

        viewModelScope.launch(Dispatchers.IO) {
            db.cartItemDao().updateCartItem(updatedProduct)
        }

        if (_cartList.value[index].quantity == 0) {
            deleteCartItem(_cartList.value[index])
        }
    }

    fun updateTotalCost(){
        var sum = 0
        _cartList.value.forEach { item ->
            sum += item.quantity * item.price
        }
        totalCost = sum
    }
}