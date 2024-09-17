package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.PatientState

class PatientListViewModel: ViewModel() {
    var addModal by mutableStateOf(false)
        private set

    var state by  mutableStateOf(PatientState())
        private set

    var patientList by mutableStateOf(listOf<PatientState>())

    fun showAddModal()
    {
        addModal = true
    }

    fun hideAddModal()
    {
        addModal = false
    }

    fun addPatient(
        name: String
    ) {
        val newPatient = state.copy(
            id = patientList.size + 1,
            name = name
        )
        patientList += newPatient
    }

    fun clean(){
        state = state.copy(name = "")
        
    }

    fun onValueName(name: String)
    {
        state = state.copy(name = name)
    }
}
