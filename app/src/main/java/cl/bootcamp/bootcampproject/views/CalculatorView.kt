package cl.bootcamp.bootcampproject.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.components.CalculateButton
import cl.bootcamp.bootcampproject.components.CalculatorModal
import cl.bootcamp.bootcampproject.components.InputTextField
import cl.bootcamp.bootcampproject.components.ResultText
import cl.bootcamp.bootcampproject.components.TitleText
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculatorView(
    viewModel: CalculatorViewModel,
    navController: NavController,
    id: Int
) {
    Scaffold()
    {
        ContentCalculatorView(
            viewModel = viewModel,
            navController = navController,
            id = id,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCalculatorView(
    viewModel: CalculatorViewModel,
    navController: NavController,
    id: Int
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .padding(4.dp)
            .padding(top = 48.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TitleText(
            text = "BMI Calculator"
        )

        Spacer(
            modifier =  Modifier.height(32.dp)
        )

        SingleChoiceSegmentedButtonRow {
            state.options.forEachIndexed { i, label ->
                SegmentedButton(
                    selected = i == state.selectedIndex,
                    onClick = {viewModel.changeSelected(i)},
                    shape = SegmentedButtonDefaults.itemShape(
                        index = i,
                        count = state.options.size
                    )
                ) {
                    Text(text = label)
                }
            }
        }

        Spacer(
            modifier =  Modifier.height(16.dp)
        )

        InputTextField(
            value = state.age,
            onValueChange = {viewModel.onValueChangeAge(it)},
            label = "Age"
        )

        Spacer(
            modifier =  Modifier.height(8.dp)
        )

        InputTextField(
            value = state.height,
            onValueChange = {viewModel.onValueChangeHeight(it)},
            label = "Height [cm]"
        )

        Spacer(
            modifier =  Modifier.height(8.dp)
        )

        InputTextField(
            value = state.weight,
            onValueChange = {viewModel.onValueChangeWeight(it)},
            label = "Weight [kg]"
        )

        CalculateButton(
            text = "Calculate"
        ) {
            try {
                viewModel.ageCheck()
                viewModel.calculateBmi(state.height.toDouble(), state.weight.toDouble())
            } catch (_ : NumberFormatException) {
                viewModel.showModal()
            }
        }

        Spacer(
            modifier =  Modifier.height(36.dp)
        )

        ResultText(
            text = state.result
        )

        if (state.showModal) {
            CalculatorModal(
                title = "Error",
                onDismiss = {viewModel.hideModal()},
                onConfirmClick = {
                    CalculateButton(
                        text = "Ok"
                    ) {
                        viewModel.hideModal()
                    }
                },
                onText = {viewModel.GenerateErrorMessage()},
            )
        }

    }
}