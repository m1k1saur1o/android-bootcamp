package cl.bootcamp.bootcampproject.components

import android.content.Context
import android.widget.Toast

fun buyToast(
    context: Context
) {
    Toast.makeText(context , "Your purchase has been successfully completed.", Toast.LENGTH_SHORT).show()
}