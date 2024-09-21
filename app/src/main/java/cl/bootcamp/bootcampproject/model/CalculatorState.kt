package cl.bootcamp.bootcampproject.model

data class CalculatorState(
    var age: String = "",
    var height: String = "",
    var weight: String = "",
    var selectedIndex: Int? = null,
    var result: String = "",
    var options: List<String> = listOf("Male", "Female"),
    var showModal: Boolean = false,
    var isCalculated: Boolean = false,
)