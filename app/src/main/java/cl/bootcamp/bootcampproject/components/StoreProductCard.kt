package cl.bootcamp.bootcampproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.bootcampproject.R

@Composable
fun StoreProductCard(
    name: String,
    price: String,
    onClick: () -> Unit,
    onLikedClick: () -> Unit,
    onDislikedClick: () -> Unit,
    image: Int,
    isLiked: Boolean
) {
    Card(
        modifier = Modifier
            .size(
                height = 220.dp,
                width = 180.dp
            )
            .padding(8.dp)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
    ) {

        if (isLiked) {
            IsLikedIcon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDislikedClick()  }
                    .padding(4.dp)
                    .align(Alignment.End),
            )
        } else {
            IsNotLikedIcon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onLikedClick() }
                    .padding(4.dp)
                    .align(Alignment.End),
            )
        }

        Box(
            modifier = Modifier
                .size(110.dp)
                .padding(4.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }

        Column{
            Text(
                text = name,
                modifier = Modifier
                    .padding(start = 12.dp),
                fontSize = 12.sp
            )

            Text(
                text = "$${price}",
                modifier = Modifier
                    .padding(start = 12.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun IsLikedIcon(
    modifier: Modifier
) {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "",
        modifier = modifier,
        tint = Color.Red
    )
}

@Composable
fun IsNotLikedIcon(
    modifier: Modifier
) {
    Icon(
        imageVector = Icons.Default.FavoriteBorder,
        contentDescription = "",
        modifier = modifier,
        tint = Color.Black
    )
}

@Preview(
    showBackground = true
)
@Composable
fun StoreCardPreview () {
    StoreProductCard(
        name = "zapatilla",
        price = "10000",
        onClick = {},
        image = R.drawable.ic_launcher_foreground,
        isLiked = true,
        onDislikedClick = {},
        onLikedClick = {}
    )
}