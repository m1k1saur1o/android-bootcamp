package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.ShowImageState

class ShowImageViewModel: ViewModel() {

    var state  by mutableStateOf(ShowImageState())
        private set

    fun buttonPressed() {
        state = state.copy(isPressed = !state.isPressed)
    }
}