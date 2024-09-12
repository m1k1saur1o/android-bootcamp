package cl.bootcamp.bootcampproject.model

data class CalculateState(
    val age: String = "",
    val height: String = "",
    val weight: String = "",
    val selectedIndex: Int? = null,
    val result: String = "",
    val options: List<String> = listOf("Man", "Woman"),
    val showModal: Boolean = false
)