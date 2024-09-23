package cl.bootcamp.bootcampproject.onBoardingView

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.data.PageData
import cl.bootcamp.bootcampproject.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPage(
    item: List<PageData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController,
    storeBoarding: StoreBoarding
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                Column(
                    modifier = Modifier
                        .padding(36.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderData(
                        modifier = Modifier
                            .size(400.dp)
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                        item[page].image
                    )
                    
                    Text(
                        text = item[page].title,
                        modifier = Modifier
                            .padding(top = 16.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Text(
                        text = item[page].description,
                        modifier = Modifier
                            .padding(top = 8.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp
                    )
                    
                }
            }

            PageIndicator(
                size = item.size,
                currentPage = pagerState.currentPage
            )
        }

        if (pagerState.currentPage == 2) {
            Box(
                modifier = Modifier
                    .padding(bottom = 48.dp)
                    .align(Alignment.BottomCenter)
            ) {
                ButtonFinish(
                    navController = navController,
                    storeBoarding = storeBoarding
                )
            }
        }
    }
}