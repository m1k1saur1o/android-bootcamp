package cl.bootcamp.bootcampproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartProductCard (
    onAddQuantity: () -> Unit,
    onRemoveQuantity: () -> Unit,
    name: String,
    price: String,
    image: Int,
    quantity: Int
) {
    Card (
        modifier = Modifier
            .height(height = 100.dp)
            .padding(4.dp)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "$${price}",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }



            Row(
            ) {
                TextButton(
                    onClick = { onAddQuantity() },
                ) {
                    Text(
                        text = "+",
                        color = Color.Black,
                    )
                }

                Text(
                    text = "$quantity",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                TextButton(
                    onClick = { onRemoveQuantity() },
                ) {
                    Text(
                        text = "-",
                        color = Color.Black
                    )
                }
            }

        }
    }
}
