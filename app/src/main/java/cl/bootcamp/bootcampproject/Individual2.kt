package cl.bootcamp.bootcampproject

fun main () {
    menu()
}

fun menu() {
    var exit = false
    var option : Int?
    var ticket : Ticket
    do {
        println(
            "1. Generar entrada. \n" +
                    "2. Salir."
        )
        print("Opción: ")
        option = readlnOrNull()?.toIntOrNull()

        if (option == null) {
            println("ERROR. Ingrese una opción permitida.")
        } else {
            when (option) {
                1 -> {
                    ticket = generateTicket()
                    println("-----------------------------------------")
                    println("Total a pagar: ${ticket.calculatePrice()}")
                    println("-----------------------------------------")
                }
                2 -> exit = true
                else -> println("ERROR. Ingrese una opción permitida.")
            }
        }

    } while (!exit)
    println("\nbai.")
}

fun generateTicket() : Ticket {

    var day : Int?
    var age : Int?

    do {

        print("Ingrese la edad: ")
        age = readlnOrNull()?.toIntOrNull()
        println("Seleccione el día: ")
        println(
            "1. Lunes. \n" +
                    "2. Martes. \n" +
                    "3. Miércoles \n" +
                    "4. Jueves \n" +
                    "5. Viernes. \n" +
                    "6. Sábado. \n" +
                    "7. Domingo. \n"
        )
        print("Opción: ")
        day = readlnOrNull()?.toIntOrNull()

        if (day == null) {
            println("ERROR. Ingrese un día válido")
        }

        if (age == null){
            println("ERROR. Ingrese una edad válida.")
        } else {
            if (age !in 0..100) {
                println("ERROR. Ingrese una edad válida.")
                age = null
            }
        }

    } while (day == null || age == null)

    return Ticket(age, day)
}

data class Ticket(val age: Int, val day: Int) {

    fun calculatePrice() : Int {
        return  when {
            age < 4 -> 0
            age in 4..15 -> 15000
            age in 16..60 -> if (day == 1 || day == 2) 25000 else 30000
            age in 61..100 -> 20000
            else -> -1
        }
    }

}