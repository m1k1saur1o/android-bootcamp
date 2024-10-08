package cl.bootcamp.bootcampproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import cl.bootcamp.bootcampproject.navigation.NavManager
import cl.bootcamp.bootcampproject.ui.theme.BootcampProjectTheme
import cl.bootcamp.bootcampproject.viewModels.ContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactsViewModel: ContactsViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            BootcampProjectTheme {
                NavManager(
                    contactsViewModel = contactsViewModel
                )
            }
        }
    }
}
