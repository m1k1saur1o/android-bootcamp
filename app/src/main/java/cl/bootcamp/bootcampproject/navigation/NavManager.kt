package cl.bootcamp.bootcampproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.bootcampproject.dataStore.StoreBoarding
import cl.bootcamp.bootcampproject.onBoardingView.MainOnBoarding
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel
import cl.bootcamp.bootcampproject.viewModels.PatientListViewModel
import cl.bootcamp.bootcampproject.views.CalculatorView
import cl.bootcamp.bootcampproject.views.PatientListView
import cl.bootcamp.bootcampproject.views.SplashScreen

@Composable
fun NavManager(
    //modifier: Modifier,
    calculatorModel: CalculatorViewModel,
    patientListModel: PatientListViewModel,
) {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (store.value) "Home/{id}/{bmi}/{gender}/{age}/{bmiState}/{isCalculated}/" else "SplashScreen"
    ) {

        composable(
            "SplashScreen"
        ) {
            SplashScreen(
                navController = navController,
                store = store.value
            )
        }

        composable(
            "OnBoarding"
        ) {
            MainOnBoarding(
                navController = navController,
                dataStore = dataStore
            )
        }

        composable(
            "Home/{id}/{bmi}/{gender}/{age}/{bmiState}/{isCalculated}/", arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("gender") { type = NavType.StringType },
                navArgument("bmi") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType },
                navArgument("bmiState") { type = NavType.StringType },
                navArgument("isCalculated") { type = NavType.BoolType }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: -1
            val bmi = it.arguments?.getString("bmi") ?: ""
            val gender = it.arguments?.getString("gender") ?: ""
            val age = it.arguments?.getString("age") ?: ""
            val bmiState = it.arguments?.getString("bmiState") ?: ""
            val isCalculated = it.arguments?.getBoolean("isCalculated") ?: false

            PatientListView(
                viewModel = patientListModel,
                navController = navController,
                id = id,
                bmi = bmi,
                gender = gender,
                age = age,
                bmiState = bmiState,
                isCalculated = isCalculated
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