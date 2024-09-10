package cl.bootcamp.bootcampproject.model

data class ShowImageState (
    val isPressed: Boolean = false,
    val isPressedText: String =  "Hide Image",
    val isNotPressedText: String = "Show Image",
    val imageURL: String = "https://www.shutterstock.com/shutterstock/photos/1126305455/display_1500/stock-vector-dinosaur-rock-singer-holding-microphone-tyrannosaurus-or-t-rex-vector-illustration-1126305455.jpg",
    val name: String = "Miguel G",
    val welcomeText: String = "Welcome!"

)