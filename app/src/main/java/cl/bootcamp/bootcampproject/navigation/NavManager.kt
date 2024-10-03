package cl.bootcamp.bootcampproject.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import cl.bootcamp.bootcampproject.viewModels.CartViewModel
import cl.bootcamp.bootcampproject.viewModels.ProductViewModel
import cl.bootcamp.bootcampproject.viewModels.StoreViewModel
import cl.bootcamp.bootcampproject.views.CartView
import cl.bootcamp.bootcampproject.views.ProductView
import cl.bootcamp.bootcampproject.views.StoreView

@Composable
fun NavManager(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    storeViewModel: StoreViewModel,
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel
) {

    NavHost(
        navHostController,
        startDestination = Routes.StoreView.route
    ) {
        composable(
            Routes.StoreView.route
        ) {
            StoreView(
                navController = navHostController,
                paddingValues = paddingValues,
                storeViewModel = storeViewModel
            )
        }

        composable(
            Routes.CartView.route
        ) {
            CartView(
                cartViewModel = cartViewModel,
                paddingValues = paddingValues,
            )
        }

        composable(
            route = "Product/{id}/{productType}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("productType") { type = NavType.StringType}
            )
        ) {

            val id = it.arguments?.getInt("id") ?: -1
            val productType = it.arguments?.getString("productType") ?: ""

            ProductView(
                cartViewModel = cartViewModel,
                productViewModel = productViewModel,
                storeViewModel = storeViewModel,
                navController = navHostController,
                paddingValues = paddingValues,
                id = id,
                productType = productType
            )
        }
    }
}