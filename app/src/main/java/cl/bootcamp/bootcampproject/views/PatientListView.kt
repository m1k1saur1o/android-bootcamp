package cl.bootcamp.bootcampproject.views

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.components.AddPatientFloatingButton
import cl.bootcamp.bootcampproject.components.AddPatientModal
import cl.bootcamp.bootcampproject.components.CalculatedBmiPatientCard
import cl.bootcamp.bootcampproject.components.CancelSaveButton
import cl.bootcamp.bootcampproject.components.PatientCard
import cl.bootcamp.bootcampproject.components.SavePatientButton
import cl.bootcamp.bootcampproject.components.TitleBar
import cl.bootcamp.bootcampproject.ui.theme.columbia_blue
import cl.bootcamp.bootcampproject.ui.theme.tropical_indigo
import cl.bootcamp.bootcampproject.viewModels.PatientListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PatientListView(
    viewModel: PatientListViewModel,
    navController: NavController,
    id: Int,
    bmi: String,
    gender: String,
    age: String,
    bmiState: String,
    isCalculated: Boolean
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Patients List") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Gray
                )
            )
        },
        floatingActionButton = {
            AddPatientFloatingButton()
            {
                viewModel.showAddModal()
            }
        }
    )
    {
        ContentPatientListView(
            viewModel = viewModel,
            navController = navController,
            id = id,
            bmi = bmi,
            gender = gender,
            age = age,
            bmiState = bmiState,
            isCalculated = isCalculated
        )
    }
}

@Composable
fun ContentPatientListView(
    viewModel: PatientListViewModel,
    navController: NavController,
    id: Int,
    bmi: String,
    gender: String,
    age: String,
    bmiState: String,
    isCalculated: Boolean
) {
    val state = viewModel.state

    if (id != -1 && isCalculated) {
        viewModel.addBmi(
            id,
            isCalculated,
            bmi,
            bmiState,
            gender,
            age
        )
    }

    LazyColumn(
        modifier = Modifier
            .padding(4.dp)
            .padding(top = 96.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        items(viewModel.patientList) { item ->

            if (item.isBmiCalculated) {
                CalculatedBmiPatientCard(
                    name = item.name,
                    age = item.age,
                    bmi = item.bmi,
                    gender = item.gender,
                    bmiState = item.bmiState,
                    modifier = Modifier
                        .border(
                            width = 4.dp, // Thickness of the border
                            color = tropical_indigo, // Border color
                            shape = RoundedCornerShape(8.dp) // Corner radius of the border
                        )
                        .fillMaxSize()
                )
            } else {
                PatientCard(
                    name = item.name,
                    modifier = Modifier
                        .border(
                            width = 4.dp, // Thickness of the border
                            color = columbia_blue, // Border color
                            shape = RoundedCornerShape(8.dp) // Corner radius of the border
                        )
                        .fillMaxSize(),
                    onClick = {
                        navController.navigate("BmiCalculator/${item.id}/")
                    }
                )
            }

            Spacer(
                Modifier
                    .padding(top = 4.dp)
            )

        }
    }

    if (viewModel.addModal) {
        AddPatientModal(
            title = "New Patient",
            onDismiss = { },
            onText =
            {
                Column {
                    OutlinedTextField(
                        value = state.name,
                        onValueChange = { viewModel.onValueName(it) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            },
            onConfirmClick =
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                ) {

                    CancelSaveButton(
                        text = "Cancel",
                    ) {
                        viewModel.hideAddModal()
                        viewModel.clean()
                    }

                    SavePatientButton(
                        text = "Add",
                    ) {
                        if (state.name.isNotBlank()) {
                            viewModel.addPatient(
                                name = state.name
                            )
                            viewModel.hideAddModal()
                            viewModel.clean()
                        }
                    }
                }
            }
        )
    }

}
