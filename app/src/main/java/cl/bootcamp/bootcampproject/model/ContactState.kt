package cl.bootcamp.bootcampproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactState(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val profileImage: String = "",
    val birthdate: String= "",
)
