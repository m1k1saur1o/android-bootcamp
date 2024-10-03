package cl.bootcamp.bootcampproject.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.navigation.Routes

@Composable
fun currentRoute(
    navHostController: NavHostController
): String? {
    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}

@Composable
fun BottomNav(
    navHostController: NavHostController,
    routes: List<Routes>
) {
    BottomAppBar {
        NavigationBar(
            containerColor = colorResource(R.color.white)
        ) {
            val currentRoute = currentRoute(navHostController = navHostController)
            routes.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = { navHostController.navigate(item.route) {
                        if (item.route != "Product/{id}/{productType}") {
                            popUpTo("Product/{id}/{productType}") {
                                inclusive = true
                            }
                        }
                        launchSingleTop = true
                    } },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = colorResource(R.color.black)
                        )
                    },
                    label = {
                        Text(
                            text = item.title
                        )
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }
}