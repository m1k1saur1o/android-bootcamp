package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import cl.bootcamp.bootcampproject.components.CalculateButton
import cl.bootcamp.bootcampproject.components.InputTextField
import cl.bootcamp.bootcampproject.components.TitleText
import cl.bootcamp.bootcampproject.viewModels.CalculatorViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    modifier: Modifier,
    viewModel: CalculatorViewModel
) {
    Scaffold()
    {
        ContentCalculatorView(it, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCalculatorView(
    paddingValues: PaddingValues,
    viewModel: CalculatorViewModel
) {

    val options: List<String> = listOf("Man", "Woman")

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
            .padding(top = 32.dp)
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
            options.forEachIndexed { i, label ->
                SegmentedButton(
                    selected = i == viewModel.selectedIndex,
                    onClick = {viewModel.changeSelected(i)},
                    shape = SegmentedButtonDefaults.itemShape(
                        index = i,
                        count = options.size
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
            value = viewModel.age,
            onValueChange = {viewModel.onValueChangeAge(it)},
            label = "Age"
        )

        Spacer(
            modifier =  Modifier.height(8.dp)
        )

        InputTextField(
            value = viewModel.height,
            onValueChange = {viewModel.onValueChangeHeight(it)},
            label = "Height"
        )

        Spacer(
            modifier =  Modifier.height(8.dp)
        )

        InputTextField(
            value = viewModel.weight,
            onValueChange = {viewModel.onValueChangeWeight(it)},
            label = "Weight"
        )

        CalculateButton(
            text = "Calculate"
        ) {}

    }
}