package cl.bootcamp.bootcampproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ContactCard(
    name: String,
    phone: String,
    email: String,
    profileImage: String,
    birthdate: String,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .height(200.dp)
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Image(
                    painter = rememberAsyncImagePainter(model = profileImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "name: $name"
                )
            }

            Column {
                Text(text = "phone: $phone")
                Text(text = "email: $email")
                Text(text = "Bd: $birthdate")
            }

            Column {
                IconButton(
                    onClick = { onEdit() },
                    modifier = Modifier
                        .padding(8.dp) // Padding inside the card
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

                IconButton(
                    onClick = { onDelete() },
                    modifier = Modifier
                        .padding(8.dp) // Padding inside the card
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }

        }
    }
}
