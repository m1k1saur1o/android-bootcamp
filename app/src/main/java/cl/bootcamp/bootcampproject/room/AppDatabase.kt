package cl.bootcamp.bootcampproject.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.bootcampproject.model.CartItemState

@Database(entities = [CartItemState::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cartItemDao(): CartItemDao
}