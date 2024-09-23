package cl.bootcamp.bootcampproject.onBoardingView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ButtonFinish(
    navController: NavController,
    storeBoarding: StoreBoarding
) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            onClick = {
                navController.navigate(
                    "Home" +
                            "/${-1}" +
                            "/${""}" +
                            "/${""}" +
                            "/${""}" +
                            "/${""}" +
                            "/${false}/"
                ) {
                    launchSingleTop = true
                    popUpTo(0)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    storeBoarding.saveBoarding(true)
                }
            }
        ) {
            Text(
                text = "Start",
                modifier = Modifier
                    .padding(24.dp),
                color = Color.Gray
            )
        }
    }
}
