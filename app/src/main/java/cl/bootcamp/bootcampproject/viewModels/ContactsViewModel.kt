package cl.bootcamp.bootcampproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.bootcampproject.model.ContactState
import cl.bootcamp.bootcampproject.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val repository: ContactsRepository
): ViewModel()
{
    private val _contactsList = MutableStateFlow<List<ContactState>>(emptyList())
    val contactsList = _contactsList.asStateFlow()

    init {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            repository.getContacts().collect { item ->
                if (item.isNullOrEmpty()) {
                    _contactsList.value = emptyList()
                } else {
                    _contactsList.value = item
                }
            }
        }
    }

    fun addContact(contact: ContactState) = viewModelScope.launch { repository.createContact(contact) }

    fun deleteContact(contact: ContactState) = viewModelScope.launch { repository.deleteContact(contact) }

    fun updateContact(contact: ContactState) = viewModelScope.launch { repository.updateContact(contact) }

}