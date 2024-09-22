package cl.bootcamp.bootcampproject.model

data class PatientState(
    var id: Int = -1,
    var name: String = "",
    var isBmiCalculated: Boolean = false,
    var bmi:String = "",
    var gender: String = "",
    var age: String = "",
    var bmiState: String = ""
)