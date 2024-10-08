package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import cl.bootcamp.bootcampproject.components.ContactCard
import cl.bootcamp.bootcampproject.viewModels.ContactsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    contactsViewModel: ContactsViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Contacts List") },
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("AddView")
                },
                containerColor = Color.Green,
                contentColor = Color.White,
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        },

    ) { paddingValues ->
        HomeViewContent(
            paddingValues = paddingValues,
            contactsViewModel = contactsViewModel,
            navController = navController
        )
    }
}

@Composable
fun HomeViewContent(
    paddingValues: PaddingValues,
    contactsViewModel: ContactsViewModel,
    navController: NavController
) {

    val contactsList by contactsViewModel.contactsList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(contactsList){ item ->
            ContactCard(
                name = item.name,
                phone = item.phone,
                email = item.email,
                profileImage = item.profileImage,
                birthdate = item.birthdate,
                onEdit = {
                    navController.navigate("EditView/${item.id}/")
                },
                onDelete = { contactsViewModel.deleteContact(item) }
            )
        }
    }
}
