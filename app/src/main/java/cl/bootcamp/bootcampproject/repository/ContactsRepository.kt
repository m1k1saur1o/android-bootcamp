package cl.bootcamp.bootcampproject.repository

import cl.bootcamp.bootcampproject.model.ContactState
import cl.bootcamp.bootcampproject.room.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val contactsDao: ContactsDao
) {
    suspend fun createContact(
        contact: ContactState
    ) = contactsDao.createContact(contact)

    suspend fun  updateContact(
        contact: ContactState
    ) = contactsDao.updateContact(contact)

    suspend fun  deleteContact(
        contact: ContactState
    ) = contactsDao.deleteContact(contact)

    fun getContacts(): Flow<List<ContactState>>
    = contactsDao
        .getContacts()
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getContactsById(id: Long): Flow<ContactState>
    = contactsDao
        .getContactsById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}