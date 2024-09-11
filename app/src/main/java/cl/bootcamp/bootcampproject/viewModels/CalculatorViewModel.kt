package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

}