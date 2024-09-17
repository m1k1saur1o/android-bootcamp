package cl.bootcamp.bootcampproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel
import cl.bootcamp.bootcampproject.viewModels.PatientListViewModel
import cl.bootcamp.bootcampproject.views.CalculatorView
import cl.bootcamp.bootcampproject.views.PatientListView

@Composable
fun NavManager(
    calculatorModel: CalculatorViewModel,
    patientListModel: PatientListViewModel,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    )
    {
        composable("Home") {
            PatientListView(
                viewModel = patientListModel,
                navController = navController,
            )
        }

        composable(
            "BmiCalculator/{id}/", arguments = listOf(
                navArgument("id") { type = NavType.IntType },
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            CalculatorView(
                viewModel = calculatorModel,
                navController = navController,
                id = id,
            )
        }

    }
}