package cl.bootcamp.bootcampproject.onBoardingView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.data.PageData
import cl.bootcamp.bootcampproject.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(
    navController: NavController,
    dataStore: StoreBoarding
) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.medic_welcome,
            "Patient Listing",
            "Create a registry of all your patients to " +
                    "keep things organized and boost your productivity!"
        )
    )

    items.add(
        PageData(
            R.raw.easy_process,
            "Easy to use!",
            "Fast and simple"
        )
    )

    items.add(
        PageData(
            R.raw.healthy,
            "Built-in BMI calculator.",
            "Calculate and store the BMI of your patients."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    
    OnBoardingPage(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController = navController,
        storeBoarding = dataStore
    )
}
