package cl.bootcamp.bootcampproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cl.bootcamp.bootcampproject.ui.theme.BootcampProjectTheme
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel
import cl.bootcamp.bootcampproject.views.CalculatorView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val calculatorModel: CalculatorViewModel by viewModels()

        setContent {
            BootcampProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorView(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = calculatorModel
                    )
                }
            }
        }
    }
}

