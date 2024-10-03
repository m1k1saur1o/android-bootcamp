package cl.bootcamp.bootcampproject.model

data class ProductState(
    val id: Int = -1,
    val name: String = "",
    val price: Pair<Int, String> = Pair(0, "0"),
    val image: Int = 0,
    val description: String = "",
    val availableSizes: List<String>? = null,
    val availableColors: List<Int>? = null,
    var isLiked: Boolean = false,
    var colorSelected: Int? = null,
    var sizeSelected: Int? = null,
    var quantity: Int = 0
)
