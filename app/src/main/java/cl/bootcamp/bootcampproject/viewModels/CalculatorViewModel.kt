package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Locale

class CalculatorViewModel: ViewModel() {
    var age by mutableStateOf("")
        private set

    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var selectedIndex by mutableStateOf(1)
        private set

    var result by mutableStateOf("")
        private set

    fun onValueChangeAge(value: String) {
        age = value
    }

    fun onValueChangeHeight(value: String) {
        height = value
    }

    fun onValueChangeWeight(value: String) {
        weight = value
    }

    fun changeSelected(index: Int) {
        selectedIndex = index
    }

    fun calculateBmi(
        height: Double,
        weight: Double
    ) {
        val bmiResult = weight / ((height * height) / 10000)
        result = String.format(Locale.US,"%.1f", bmiResult)
    }

}