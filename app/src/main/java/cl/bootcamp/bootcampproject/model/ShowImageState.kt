package cl.bootcamp.bootcampproject.model
import cl.bootcamp.bootcampproject.R

data class ShowImageState (
    val isPressed: Boolean = false,
    val isPressedText: String =  "Hide List",
    val isNotPressedText: String = "Show List",
    val name: String = "Miguel G",
    val welcomeText: String = "Welcome!",
    val imagePaths: List<Int> = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )

)