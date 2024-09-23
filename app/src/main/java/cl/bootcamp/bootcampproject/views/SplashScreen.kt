package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.onBoardingView.LoaderData
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, store: Boolean) {
    var screen by remember { mutableStateOf("") }
    screen = if (store) "Home/{id}/{bmi}/{gender}/{age}/{bmiState}/{isCalculated}/" else "OnBoarding"

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(screen) {
            popUpTo(0)
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LoaderData(
            modifier = Modifier
                .size(600.dp)
                .fillMaxWidth(),
            image = R.raw.loading
        )
    }

}