package cl.bootcamp.bootcampproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItemState(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val price: Int = 0,
    val textPrice: String = "0",
    val image: Int = 0,
    val quantity: Int = 0
)
