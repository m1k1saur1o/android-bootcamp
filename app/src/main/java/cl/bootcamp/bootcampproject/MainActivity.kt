package cl.bootcamp.bootcampproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import cl.bootcamp.bootcampproject.navigation.NavManager
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel
import cl.bootcamp.bootcampproject.viewModels.PatientListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val calculatorModel: CalculatorViewModel by viewModels()
        val patientListModel: PatientListViewModel by viewModels()

        setContent {
            NavManager(
                calculatorModel,
                patientListModel,
                )
        }
    }
}

