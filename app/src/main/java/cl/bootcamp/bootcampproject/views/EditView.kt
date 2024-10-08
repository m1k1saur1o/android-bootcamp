package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.viewModels.ContactsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditView(
    navController: NavController,
    contactsViewModel: ContactsViewModel,
    id: Long
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Edit Contact") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("HomeView") {
                                launchSingleTop = true
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                },
            )
        },

        ) { paddingValues ->
        EditViewContent(
            paddingValues = paddingValues,
            contactsViewModel = contactsViewModel,
            navController = navController,
            id = id
        )
    }
}

@Composable
fun EditViewContent(
    contactsViewModel: ContactsViewModel,
    paddingValues: PaddingValues,
    navController: NavController,
    id: Long
) {

    val contactState by contactsViewModel.contact.collectAsState()

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var profileImage by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }

    LaunchedEffect(id) {
        contactsViewModel.getContactById(id)
    }

    contactState?.let { contact ->

        LaunchedEffect(contact) {
            name = contact.name
            phone = contact.phone
            email = contact.email
            profileImage = contact.profileImage
            birthdate = contact.birthdate
        }

        Column(
            modifier = Modifier
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text(text = "Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { newText -> phone = newText },
                label = { Text(text = "Phone") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )

            OutlinedTextField(
                value = profileImage,
                onValueChange = { newText -> profileImage = newText },
                label = { Text(text = "Image") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )

            OutlinedTextField(
                value = birthdate,
                onValueChange = { newText -> birthdate = newText },
                label = { Text(text = "Birthdate") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )

            Button(
                onClick = {
                    if (
                        name.isNotBlank() &&
                        phone.isNotBlank() &&
                        email.isNotBlank() &&
                        profileImage.isNotBlank() &&
                        birthdate.isNotBlank()
                    ) {
                        val updatedContact = contact.copy(
                            name = name,
                            phone = phone,
                            email = email,
                            profileImage = profileImage,
                            birthdate = birthdate
                        )
                        contactsViewModel.updateContact(updatedContact)
                        navController.navigate("HomeView") {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                }
            ) {
                Text(text = "Edit")
            }
        }
    } ?: run {
        Text(text = "Loading")
    }

}
