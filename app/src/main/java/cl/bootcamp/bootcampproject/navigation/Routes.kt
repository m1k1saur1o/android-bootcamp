package cl.bootcamp.bootcampproject.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object StoreView: Routes(Icons.Default.Home, "Store", "StoreView")
    object CartView: Routes(Icons.Default.ShoppingCart, "Cart", "CartView")
}