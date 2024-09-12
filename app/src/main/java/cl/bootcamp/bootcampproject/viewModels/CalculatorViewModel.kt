package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.CalculateState
import java.util.Locale

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculateState())
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

    fun calculateBmi(
        height: Double,
        weight: Double
    ) {
        val bmiResult = weight / ((height * height) / 10000)
        state = state.copy(result = String.format(Locale.US,"%.1f", bmiResult))
    }

    fun showModal () {
        state = state.copy(showModal = true)
    }

    fun hideModal () {
        state = state.copy(showModal = false)
    }

    @Composable
    fun GenerateErrorMessage() {
        var errorMessage = ""

        if(intParseCheck(state.age)) {
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

    fun ageCheck() {
        state.age.toInt()
    }

    private fun doubleParseCheck(input: String): Boolean {
        return input.toDoubleOrNull() == null
    }

    private fun intParseCheck(input: String): Boolean {
        return input.toIntOrNull() == null
    }
}