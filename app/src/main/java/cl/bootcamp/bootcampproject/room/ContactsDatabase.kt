package cl.bootcamp.bootcampproject.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.bootcampproject.model.ContactState

@Database(
    entities = [ContactState::class],
    version = 1,
    exportSchema = false
)
abstract class ContactsDatabase: RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}