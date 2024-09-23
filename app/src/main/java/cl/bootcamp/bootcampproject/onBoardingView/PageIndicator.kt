package cl.bootcamp.bootcampproject.onBoardingView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    size: Int,
    currentPage: Int
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 64.dp)
    ) {
        repeat(
            size
        ) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(
    isSelected: Boolean
) {
    Box (
        modifier = Modifier
            .padding(8.dp)
            .height(10.dp)
            .width(10.dp)
            .clip(CircleShape)
            .background(if (isSelected) Color.Blue else Color.Gray),
    ) {

    }
}