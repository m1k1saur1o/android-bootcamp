package cl.bootcamp.bootcampproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.bootcamp.bootcampproject.model.ContactState
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Query("SELECT * FROM contacts")
    fun getContacts(): Flow<List<ContactState>>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactsById(id: Long): Flow<ContactState>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createContact(contact: ContactState)

    @Delete
    suspend fun deleteContact(contact: ContactState)

    @Update
    suspend fun updateContact(contact: ContactState)
}