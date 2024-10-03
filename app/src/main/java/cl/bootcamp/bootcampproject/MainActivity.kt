package cl.bootcamp.bootcampproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import cl.bootcamp.bootcampproject.ui.theme.BootcampProjectTheme
import cl.bootcamp.bootcampproject.viewModels.CartViewModel
import cl.bootcamp.bootcampproject.viewModels.ProductViewModel
import cl.bootcamp.bootcampproject.viewModels.StoreViewModel
import cl.bootcamp.bootcampproject.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val storeViewModel: StoreViewModel by viewModels()
        val cartViewModel: CartViewModel by viewModels()
        val productViewModel: ProductViewModel by viewModels()

        setContent {
            BootcampProjectTheme {
                HomeView(
                    storeViewModel = storeViewModel,
                    cartViewModel = cartViewModel,
                    productViewModel = productViewModel
                )
            }
        }
    }
}
