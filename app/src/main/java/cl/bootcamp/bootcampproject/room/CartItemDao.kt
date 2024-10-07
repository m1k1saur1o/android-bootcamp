package cl.bootcamp.bootcampproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.bootcamp.bootcampproject.model.CartItemState
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {

    @Query("SELECT * FROM cart_items")
    fun getCartItems(): Flow<List<CartItemState>>

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(item: CartItemState)

    @Delete
    suspend fun deleteCartItem(item: CartItemState)

    @Update
    suspend fun updateCartItem(cartItem: CartItemState)
}