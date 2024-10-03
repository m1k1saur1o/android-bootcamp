package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.components.AppBarView
import cl.bootcamp.bootcampproject.components.ProductTitle
import cl.bootcamp.bootcampproject.components.StoreProductCard
import cl.bootcamp.bootcampproject.viewModels.StoreViewModel

@Composable
fun StoreView(
    navController: NavController,
    paddingValues: PaddingValues,
    storeViewModel: StoreViewModel
)
{
    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            AppBarView(
                title = stringResource(R.string.store_title)
            )
        }
    ) { innerPadding ->
        ContentStoreView(
            navController = navController,
            storeViewModel = storeViewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ContentStoreView(
    navController: NavController,
    storeViewModel: StoreViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        ProductTitle(
            title = "Sneakers"
        )

        LazyRow(

        ) {
            items(storeViewModel.sneakersList) { items ->
                StoreProductCard(
                    name = items.name,
                    price = items.price.second,
                    onClick = { navController.navigate("Product/${items.id}/${"sneaker"}")
                    {
                        launchSingleTop = true
                    } },
                    onLikedClick = { storeViewModel.addSneakerLike(items.id) },
                    onDislikedClick = { storeViewModel.removeSneakerLike(items.id) },
                    image = items.image,
                    isLiked = items.isLiked
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ProductTitle(
            title = "Oxfords"
        )

        LazyRow(

        ) {
            items(storeViewModel.oxfordsList) { items ->
                StoreProductCard(
                    name = items.name,
                    price = items.price.second,
                    onClick = { navController.navigate("Product/${items.id}/${"oxford"}"){
                        launchSingleTop = true
                    } },
                    onLikedClick = { storeViewModel.addOxfordLike(items.id) },
                    onDislikedClick = { storeViewModel.removeOxfordLike(items.id) },
                    image = items.image,
                    isLiked = items.isLiked
                )
            }
        }
    }
}

