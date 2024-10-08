package cl.bootcamp.bootcampproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.bootcampproject.viewModels.ContactsViewModel
import cl.bootcamp.bootcampproject.views.AddView
import cl.bootcamp.bootcampproject.views.EditView
import cl.bootcamp.bootcampproject.views.HomeView

@Composable
fun NavManager(
    contactsViewModel: ContactsViewModel,
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "HomeView"
    ) {
        composable(
            "HomeView"
        ) {
            HomeView(
                contactsViewModel,
                navController
            )
        }

        composable(
            "AddView"
        ){
            AddView(
                contactsViewModel = contactsViewModel,
                navController = navController
            )
        }

        composable(
            "EditView/{id}/", arguments = listOf(
                navArgument("id") { type = NavType.LongType },
            )
        ) {
            val id = it.arguments?.getLong("id") ?: 0
            EditView(
                contactsViewModel = contactsViewModel,
                navController = navController,
                id = id,
            )
        }
    }
}

