package cl.bootcamp.bootcampproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactState(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var name: String = "",
    var phone: String = "",
    var email: String = "",
    var profileImage: String = "",
    var birthdate: String= "",
)
