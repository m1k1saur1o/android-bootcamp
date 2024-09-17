package cl.bootcamp.bootcampproject.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String) {
    Text(
        text = name,
        fontSize = 25.sp,
        color = Color.White
    )
}
