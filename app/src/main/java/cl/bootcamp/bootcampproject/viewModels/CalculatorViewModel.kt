package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var age by mutableStateOf("")
        private set

    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var selectedIndex by mutableStateOf(1)
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

}