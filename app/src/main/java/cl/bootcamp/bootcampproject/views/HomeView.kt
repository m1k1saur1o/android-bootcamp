package cl.bootcamp.bootcampproject.views

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.bootcampproject.components.BottomNav
import cl.bootcamp.bootcampproject.navigation.NavManager
import cl.bootcamp.bootcampproject.navigation.Routes
import cl.bootcamp.bootcampproject.viewModels.StoreViewModel
import cl.bootcamp.bootcampproject.viewModels.CartViewModel
import cl.bootcamp.bootcampproject.viewModels.ProductViewModel

@Composable
fun HomeView(
    storeViewModel: StoreViewModel,
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel
)
{
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.StoreView,
        Routes.CartView
    )

    Scaffold(
        bottomBar = {
            BottomNav(
                navHostController = navController,
                routes = navigationRoutes
            )
        }
    ) { paddingValues ->
        NavManager(
            navHostController = navController,
            paddingValues = paddingValues,
            storeViewModel = storeViewModel,
            cartViewModel = cartViewModel,
            productViewModel = productViewModel
        )
    }
}
