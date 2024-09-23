package cl.bootcamp.bootcampproject.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.ui.theme.russian_violet

@Composable
fun PatientCard(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = name,
                modifier = Modifier
                    .padding(top = 24.dp),
                style = TextStyle(
                    fontSize = 24.sp
                )
            )

            CalculateBmiButton(
                text = "BMI",
                onClick = onClick
            )


        }
    }
}

@Composable
fun CalculatedBmiPatientCard(
    name: String,
    age: String,
    bmi: String,
    gender: String,
    bmiState: String,
    modifier: Modifier
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = name,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .padding(top = 12.dp),
                style = TextStyle(
                    fontSize = 24.sp
                )
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Age: $age",
                    modifier = Modifier
                        .padding(4.dp),
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )

                if (gender == "male") {
                    Icon(painter = painterResource(id = R.drawable.male),
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)
                    )
                } else {
                    Icon(painter = painterResource(id = R.drawable.female),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Bmi: $bmi",
                    modifier = Modifier
                        .padding(4.dp),
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )

                Text(
                    text = bmiState,
                    modifier = Modifier
                        .padding(4.dp),
                    style = TextStyle(
                        color = generateBmiStateColor(bmiState),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

fun generateBmiStateColor(bmiString: String): Color {
    return when (bmiString) {
        "Underweight" -> Color.Blue
        "Healthy" -> Color.Green
        "Overweight" -> Color.Yellow
        "Obesity Class 1" -> Color.Red
        "Obesity Class 2" -> Color.Red
        "Obesity Class 3" -> Color.Red
        else -> Color.White
    }
}

@Composable
private fun CalculateBmiButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = russian_violet
        )
    }
}