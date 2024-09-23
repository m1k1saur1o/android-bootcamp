package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.CalculatorState
import java.util.Locale

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onValueChangeAge(value: String) {
        state = state.copy(age = value)
    }

    fun onValueChangeHeight(value: String) {
        state = state.copy(height = value)
    }

    fun onValueChangeWeight(value: String) {
        state = state.copy(weight = value)
    }

    fun changeSelected(index: Int) {
        state = state.copy(selectedIndex = index)
    }

    private fun calculateBmi(
        height: Double,
        weight: Double
    ) {
        val bmiResult = weight / ((height * height) / 10000)
        state = state.copy(result = String.format(Locale.US, "%.1f", bmiResult))
    }

    fun showModal() {
        state = state.copy(showModal = true)
    }

    fun hideModal() {
        state = state.copy(showModal = false)
    }

    private fun isCalculated() {
        state = state.copy(isCalculated = true)
    }

    private fun isNotCalculated() {
        state = state.copy(isCalculated = false)
    }

    private fun getBmi(): Double {
        return state.result.toDouble()
    }

    @Composable
    fun GenerateErrorMessage() {
        var errorMessage = ""

        if (state.selectedIndex == null) {
            errorMessage += "Select a gender.\n"
        }

        if (intParseCheck(state.age)) {
            errorMessage += "Enter a correct age.\n"
        }

        if (doubleParseCheck(state.height)) {
            errorMessage += "Enter a correct height.\n"
        }

        if (doubleParseCheck(state.weight)) {
            errorMessage += "Enter a correct weight."
        }

        return Text(
            text = errorMessage,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            style = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        )
    }

    fun generateBmiStateText(): Pair<String, Color> {
        val bmi = getBmi()
        return when {
            bmi < 18.5 -> Pair("Underweight", Color.Blue)
            bmi in 18.5 .. 24.9 -> Pair("Healthy", Color.Green)
            bmi in 25.0 .. 29.9 -> Pair("Overweight", Color.Yellow)
            bmi in 30.0 .. 34.9 -> Pair("Obesity Class 1", Color.Red)
            bmi in 35.0 .. 39.9 -> Pair("Obesity Class 2", Color.Red)
            bmi > 40.0 -> Pair("Obesity Class 3", Color.Red)
            else -> Pair("", Color.White)
        }
    }

    private fun ageCheck() {
        state.age.toInt()
    }

    private fun doubleParseCheck(input: String): Boolean {
        return input.toDoubleOrNull() == null
    }

    private fun intParseCheck(input: String): Boolean {
        return input.toIntOrNull() == null
    }

    fun clean() {
        state = state.copy(
            age = "",
            height = "",
            weight = "",
            selectedIndex = null,
            result = "",
            showModal = false,
            isCalculated = false,
        )
    }

    fun calculateBmi(): Boolean {
        if (state.selectedIndex != null) {
            try {
                ageCheck()
                calculateBmi(state.height.toDouble(), state.weight.toDouble())
                isCalculated()
            } catch (_: NumberFormatException) {
                isNotCalculated()
                return true
            }
        } else {
            isNotCalculated()
            return true
        }
        return false
    }
}