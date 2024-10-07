package cl.bootcamp.bootcampproject.views

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.components.AppBarView
import cl.bootcamp.bootcampproject.components.CartProductCard
import cl.bootcamp.bootcampproject.components.buyToast
import cl.bootcamp.bootcampproject.viewModels.CartViewModel

@Composable
fun CartView(
    cartViewModel: CartViewModel,
    paddingValues: PaddingValues
)
{
    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            AppBarView(
                title = stringResource(R.string.cart)
            )
        }
    ) { innerPadding ->
        ContentCartView(
            context = LocalContext.current,
            cartViewModel = cartViewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ContentCartView(
    context: Context,
    cartViewModel: CartViewModel,
    modifier: Modifier = Modifier,
) {
    val cartItems by cartViewModel.cartList.collectAsState()

    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(cartViewModel.cartList.value) { items ->
                if (items.quantity > 0) {
                    CartProductCard(
                        name = items.name,
                        price = items.textPrice,
                        image = items.image,
                        quantity = items.quantity,
                        onAddQuantity = {
                            cartViewModel.addQuantity(items.id)
                            cartViewModel.updateTotalCost()
                                        },
                        onRemoveQuantity = {
                            cartViewModel.removeQuantity(items.id)
                            cartViewModel.updateTotalCost()
                        }
                    )
                }
            }
        }

        if (cartItems.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "$${ cartViewModel.totalCost }",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = { cartViewModel.clearCart() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = colorResource(R.color.black),
                        contentDescription = null
                    )
                }

                Button(
                    onClick = {
                        if (cartItems.isNotEmpty()){
                            cartViewModel.clearCart()
                            buyToast(context)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.black)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .height(60.dp)
                        .width(100.dp),
                ) {
                    Text(
                        text = "Buy",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}