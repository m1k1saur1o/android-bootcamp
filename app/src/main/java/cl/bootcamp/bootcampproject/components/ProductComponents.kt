package cl.bootcamp.bootcampproject.components

import android.content.Context
import android.widget.Toast

fun errorToast(
    context: Context
) {
    Toast.makeText(context , "Please select a Size and Color if available", Toast.LENGTH_SHORT).show()
}