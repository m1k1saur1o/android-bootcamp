package cl.bootcamp.bootcampproject.di

import android.content.Context
import androidx.room.Room
import cl.bootcamp.bootcampproject.room.ContactsDao
import cl.bootcamp.bootcampproject.room.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesContactsDao(
        contactsDatabase: ContactsDatabase
    ): ContactsDao {
        return contactsDatabase.contactsDao()
    }

    @Singleton
    @Provides
    fun providesContactsDatabase(
        @ApplicationContext context: Context
    ): ContactsDatabase {
        return Room.databaseBuilder(
            context,
            ContactsDatabase::class.java,
            "contacts_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

}