package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.model.ProductState

class ProductViewModel: ViewModel()
{
    var colorSelected by mutableIntStateOf(-1)
        private set

    var sizeSelected by mutableIntStateOf(-1)
        private set

    var state by mutableStateOf(ProductState())
        private set

    fun setProduct(product: ProductState) {
        state = product
    }

    fun changeColorSelected(
        index: Int
    ) {
        colorSelected = index
    }

    fun changeSizeSelected(
        index: Int
    ) {
        sizeSelected = index
    }

    fun clean(){
        colorSelected = -1
        sizeSelected = -1
        state = ProductState()
    }
}