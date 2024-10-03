package cl.bootcamp.bootcampproject.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.components.AppBarView
import cl.bootcamp.bootcampproject.components.errorToast
import cl.bootcamp.bootcampproject.navigation.Routes
import cl.bootcamp.bootcampproject.viewModels.CartViewModel
import cl.bootcamp.bootcampproject.viewModels.ProductViewModel
import cl.bootcamp.bootcampproject.viewModels.StoreViewModel

@Composable
fun ProductView(
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel,
    storeViewModel: StoreViewModel,
    navController: NavController,
    paddingValues: PaddingValues,
    id: Int,
    productType: String
) {
    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            AppBarView(
                title = stringResource(R.string.product)
            ) {
                navController.navigate(
                    Routes.StoreView.route
                ) {
                    popUpTo("Product/{id}/{productType}") {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        }
    ) { innerPadding ->

        DisposableEffect(Unit) {
            onDispose {
                productViewModel.clean()
            }
        }

        ContentProductView(
            context = LocalContext.current,
            navController = navController,
            cartViewModel = cartViewModel,
            productViewModel = productViewModel,
            storeViewModel = storeViewModel,
            modifier = Modifier.padding(innerPadding),
            id = id,
            productType = productType
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentProductView(
    context: Context,
    navController: NavController,
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel,
    storeViewModel: StoreViewModel,
    modifier: Modifier = Modifier,
    id: Int,
    productType: String
) {

    val scrollStateColorsRow = rememberScrollState()
    val scrollStateSizesRow = rememberScrollState()
    val scrollStateColumn = rememberScrollState()

    when (productType) {
        "sneaker" -> {
            val index = storeViewModel.sneakersList.indexOfFirst { it.id == id }
            productViewModel.setProduct(storeViewModel.sneakersList[index])
        }

        "oxford" -> {
            val index = storeViewModel.oxfordsList.indexOfFirst { it.id == id }
            productViewModel.setProduct(storeViewModel.oxfordsList[index])
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollStateColumn),
    ) {
        Box(
            modifier = Modifier
                .size(350.dp)
                .padding(4.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Image(
                painter = painterResource(id = productViewModel.state.image),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = productViewModel.state.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = productViewModel.state.description,
            modifier = Modifier
                .padding(8.dp)
        )

        if (productViewModel.state.availableColors != null) {
            Row(
                modifier = Modifier
                    .horizontalScroll(scrollStateColorsRow)
                    .padding(8.dp)
            ) {
                SingleChoiceSegmentedButtonRow {
                    productViewModel.state.availableColors!!.forEachIndexed { i, label ->
                        SegmentedButton(
                            selected = i == productViewModel.colorSelected,
                            onClick = { productViewModel.changeColorSelected(i) },
                            colors = SegmentedButtonDefaults.colors(
                                inactiveBorderColor = colorResource(R.color.black),
                                inactiveContainerColor = Color(label),
                                activeContainerColor = Color(label)
                            ),
                            shape = CircleShape,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(50.dp)
                                .then(
                                    if (i == productViewModel.colorSelected) {
                                        Modifier.border(
                                            width = 4.dp,
                                            color = MaterialTheme.colorScheme.primary,
                                            shape = CircleShape
                                        )
                                    } else Modifier // No border if not selected
                                )
                        ) {}
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollStateSizesRow)
                .padding(8.dp)
        ) {
            SingleChoiceSegmentedButtonRow {
                productViewModel.state.availableSizes!!.forEachIndexed { i, label ->
                    SegmentedButton(
                        selected = i == productViewModel.sizeSelected,
                        onClick = { productViewModel.changeSizeSelected(i) },
                        colors = SegmentedButtonDefaults.colors(
                            inactiveBorderColor = colorResource(R.color.black),
                            inactiveContainerColor = colorResource(R.color.white),
                        ),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .padding(4.dp)
                            .width(70.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = label,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                if (productViewModel.state.availableColors != null) {
                    if (productViewModel.sizeSelected == -1 || (productViewModel.colorSelected == -1)) {
                        errorToast(context)
                    } else {
                        cartViewModel.addToCart(
                            productViewModel.state.copy(
                                colorSelected = productViewModel.colorSelected,
                                sizeSelected = productViewModel.sizeSelected,
                                quantity = 1
                            )
                        )
                        navController.navigate(
                            Routes.StoreView.route
                        ) {
                            popUpTo("Product/{id}/{productType}") {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                } else {
                    if (productViewModel.sizeSelected == -1) {
                        errorToast(context)
                    } else {
                        cartViewModel.addToCart(
                            productViewModel.state.copy(
                                sizeSelected = productViewModel.sizeSelected,
                                quantity = 1
                            )
                        )
                        navController.navigate(
                            Routes.StoreView.route
                        ) {
                            popUpTo("Product/{id}/{productType}") {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.black)
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(60.dp)
        ) {
            Text(
                text = "Add to Cart",
                fontSize = 18.sp
            )
        }
    }
}