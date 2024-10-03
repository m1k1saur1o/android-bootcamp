package cl.bootcamp.bootcampproject.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductTitle(
    title: String
) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )
}