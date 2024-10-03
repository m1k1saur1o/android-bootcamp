package cl.bootcamp.bootcampproject.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import cl.bootcamp.bootcampproject.R
import cl.bootcamp.bootcampproject.model.ProductState

class StoreViewModel : ViewModel() {
    var state by mutableStateOf(ProductState())
        private set

    var sneakersList by mutableStateOf(listOf<ProductState>())
        private set

    var oxfordsList by mutableStateOf(listOf<ProductState>())
        private set

    init {
        initStoreSneakers()
        initStoreOxfords()
    }

    private fun initStoreSneakers()
    {
        val sneaker1 = ProductState(
            id = 1,
            name = "Converse Sneaker",
            price = Pair(54990, "54.990"),
            image = R.drawable.converse_sneaker,
            description = "The Converse sneaker offers a timeless design with a durable " +
                    "canvas upper, rubber sole, and classic lace-up style. Its iconic " +
                    "high-top silhouette and versatile look make it perfect for everyday " +
                    "wear or casual outings.",
            availableSizes = listOf(
                "35",
                "36",
                "36.5",
                "37",
                "37.5",
                "38",
                "39",
                "39.5",
                "40",
                "41",
                "41.5",
                "42",
                "42.5",
                "43",
                "44",
                "44.5",
                "45",
                "46",
                "47",
                "48"),
            availableColors = listOf(
                Color.Blue.toArgb(),
                Color.White.toArgb(),
                Color.Red.toArgb(),
                Color.Yellow.toArgb(),
                Color.Black.toArgb()
            ),
        )

        val sneaker2 = ProductState(
            id = 2,
            name = "Adidas Sneaker",
            price = Pair(89990, "89.990"),
            image = R.drawable.adidas_sneaker,
            description = "The Adidas sneaker blends sporty style with all-day comfort. " +
                    "Featuring a breathable mesh upper, cushioned midsole, and durable rubber" +
                    " outsole, it provides excellent support for active lifestyles. A sleek " +
                    "design with the signature three stripes adds a modern touch.",
            availableSizes = listOf(
                "35",
                "36",
                "36.5",
                "37",
                "37.5",
                "38",
                "39",
                "39.5",
                "40",
                "40.5",
                "41",
                "41.5",
                "42",
                "42.5",
                "43",
                "44",
                "44.5",
                "45",
                "46",
                "47",
                "48"),
            availableColors = listOf(
                Color.Gray.toArgb(),
                Color.Blue.toArgb(),
                Color.Red.toArgb()
            ),
        )

        val sneaker3 = ProductState(
            id = 3,
            name = "Gucci Sneaker",
            price = Pair(620000, "620.000"),
            image = R.drawable.gucci_sneaker,
            description = "The Gucci sneaker exudes luxury and sophistication, featuring " +
                    "premium leather with the iconic GG logo and distinctive green-red-green" +
                    " stripes. Its sleek silhouette combines contemporary design with classic" +
                    " elements, ensuring a stylish look for any occasion while providing " +
                    "exceptional comfort.",
            availableSizes = listOf(
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46"
            ),
        )

        val sneaker4 = ProductState(
            id = 4,
            name = "Under Armour Running Shoe",
            price = Pair(74990, "74.990"),
            image = R.drawable.under_armour_sneaker,
            description = "The Under Armour running sneaker is engineered for performance, " +
                    "featuring a lightweight, breathable upper and responsive cushioning for " +
                    "optimal comfort. With a durable outsole for superior traction, it supports" +
                    " every stride, making it ideal for runners of all levels.",
            availableSizes = listOf(
                "36",
                "37",
                "37.5",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "44.5",
                "45",
                "46",
                "47"
            ),
            availableColors = listOf(
                Color.Black.toArgb(),
                Color.Blue.toArgb(),
                Color.Yellow.toArgb(),
                Color.Red.toArgb(),
                Color.Cyan.toArgb()
            ),
        )

        val sneaker5 = ProductState(
            id = 5,
            name = "Nike Sneaker",
            price = Pair(92990,"92.990"),
            image = R.drawable.nike_sneaker,
            description = "The Nike sneaker combines cutting-edge design with superior comfort, " +
                    "featuring a lightweight mesh upper for breathability and responsive cushioning " +
                    "for all-day support. Its sleek silhouette and iconic swoosh logo make it a versatile " +
                    "choice for both workouts and casual wear.",
            availableSizes = listOf(
                "35",
                "36",
                "36.5",
                "37.5",
                "38",
                "39",
                "40",
                "40.5",
                "41",
                "42",
                "42.5",
                "43",
                "44",
                "44.5",
                "45",
                "46",
                "47"
            ),
        )

        sneakersList = listOf(sneaker1, sneaker2, sneaker3, sneaker4, sneaker5)
    }

    private fun initStoreOxfords()
    {
        val oxford1 = ProductState(
            id = 1,
            name = "Balenciaga Oxford",
            price = Pair(750000, "750.000"),
            image = R.drawable.balenciaga_oxford,
            description = "The Balenciaga Oxford shoe redefines elegance with its sleek " +
                    "silhouette and luxurious craftsmanship. Made from premium leather, " +
                    "it features a polished finish, classic lace-up design, and subtle " +
                    "branding, making it perfect for both formal occasions and sophisticated " +
                    "everyday wear.",
            availableSizes = listOf(
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45"
            ),
        )

        val oxford2 = ProductState(
            id = 2,
            name = "Black Leather Oxford",
            price = Pair(69900,"69.990"),
            image = R.drawable.black_oxford,
            description = "This black leather handcrafted Oxford shoe showcases exquisite" +
                    " craftsmanship and timeless elegance. Featuring a smooth finish, " +
                    "classic lace-up design, and meticulous stitching, it offers superior " +
                    "comfort and durability. Perfect for formal occasions or adding a " +
                    "sophisticated touch to any outfit.",
            availableSizes = listOf(
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48"
            ),
        )

        val oxford3 = ProductState(
            id = 3,
            name = "Brown Leather Oxford",
            price = Pair(69900,"69.990"),
            image = R.drawable.brown_oxford,
            description = "This brown leather handcrafted Oxford shoe combines sophistication " +
                    "and durability. With its rich, polished finish and intricate stitching, " +
                    "it offers a timeless design that elevates any formal attire. The cushioned" +
                    " insole ensures all-day comfort, making it perfect for both business and " +
                    "leisure.",
            availableSizes = listOf(
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48"
            ),
        )

        val oxford4 = ProductState(
            id = 4,
            name = "Gucci Oxford",
            price = Pair(970000, "970.000"),
            image = R.drawable.gucci_oxford,
            description = "The Gucci Oxford shoe exemplifies luxury and sophistication, " +
                    "featuring premium leather with a sleek, polished finish. Its classic " +
                    "lace-up design is adorned with the iconic GG logo and subtle branding, " +
                    "making it a stylish choice for formal occasions and upscale events.",
            availableSizes = listOf(
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45"
            ),
        )

        val oxford5 = ProductState(
            id = 5,
            name = "Louis Vuitton Oxford",
            price = Pair(1200000, "1.200.000"),
            image = R.drawable.louis_vuitton_oxford,
            description = "The Louis Vuitton Oxford shoe embodies elegance and luxury, " +
                    "crafted from high-quality leather with a refined shine. Its classic " +
                    "silhouette features the iconic LV monogram subtly embossed, while the" +
                    " meticulous craftsmanship ensures durability and comfort, making it " +
                    "perfect for sophisticated occasions.",
            availableSizes = listOf(
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45"
            ),
        )

        oxfordsList = listOf(oxford1, oxford2, oxford3, oxford4, oxford5)
    }

    fun addSneakerLike (
        id: Int
    ) {
        val index = sneakersList.indexOfFirst {it.id == id}
        val updatedSneaker = sneakersList[index].copy(
            isLiked = true,
        )
        sneakersList = sneakersList.toMutableList().apply{
            this[index] = updatedSneaker
        }
    }

    fun removeSneakerLike (
        id: Int
    ) {
        val index = sneakersList.indexOfFirst {it.id == id}
        val updatedSneaker = sneakersList[index].copy(
            isLiked = false,
        )
        sneakersList = sneakersList.toMutableList().apply{
            this[index] = updatedSneaker
        }
    }

    fun addOxfordLike (
        id: Int
    ) {
        val index = oxfordsList.indexOfFirst {it.id == id}
        val updatedOxford = oxfordsList[index].copy(
            isLiked = true,
        )
        oxfordsList = oxfordsList.toMutableList().apply{
            this[index] = updatedOxford
        }
    }

    fun removeOxfordLike (
        id: Int
    ) {
        val index = oxfordsList.indexOfFirst {it.id == id}
        val updatedOxford = oxfordsList[index].copy(
            isLiked = false,
        )
        oxfordsList = oxfordsList.toMutableList().apply{
            this[index] = updatedOxford
        }
    }
}