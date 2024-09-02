package cl.bootcamp.bootcampproject

fun main () {
    val users : MutableList<User> = mutableListOf()
    menu(users)
}

class User (private val name : String,
            private val age : Int,
            private val work : String?,
            private val reference : User?) {

    fun showData() {

        println("Nombre: $name")
        println("Edad: $age")
        if (work != null) println("Trabajo: $work")
        if (reference != null) println("Fue citado por: ${reference.name} de ${reference.age} años")

    }

    fun getName() : String {
        return name
    }

}

fun createUser(users : List<User>) : User {
    var name : String?
    var age : Int?
    var work : String?
    var reference : User?

    do {

        print("Ingrese el nombre: ")
        name = readlnOrNull()
        if (name.isNullOrBlank()) name = null

        print("Ingrese la edad: ")
        age = readlnOrNull()?.toIntOrNull()

        print("Ingrese el trabajo: ")
        work = readlnOrNull()

        reference = referenceMenu(users)

        if (age == null) {
            println("ERROR. Ingrese una edad válida.")
        }

        if (name == null || name == "") {
            println("ERROR. Ingrese un nombre válido.")
        }

    } while (name == null || age == null)

    return User(name, age, work, reference)
}

fun referenceMenu(users : List<User>) : User? {
    var index : Int? = 0

    do {

        print("¿Desea ingresar una referencia? (y/n): ")
        var option = readlnOrNull()

        if (option != "y" && option != "n") {

            println("ERROR. Ingrese y o n")

        } else {

            if (option == "y") {

                if (users.isEmpty()) {

                    println("No hay usuarios registrados")
                    return null

                } else {

                    users.forEachIndexed { i, user ->
                        println("Índice: $i | Usuario: ${user.getName()}")
                    }

                    do {

                        print("Seleccione un usuario: ")
                        index = readlnOrNull()?.toIntOrNull()

                        if (index !in users.indices) {

                            println("ERROR. ingrese un índice válido")

                        }

                    } while (index !in users.indices)

                }

            } else {

                return  null

            }

        }

    } while (option != "y" && option != "n")

    return users[index!!]
}

fun showUser(users: List<User>) {
    var index : Int?

    users.forEachIndexed { i, user ->
        println("Índice: $i | Usuario: ${user.getName()}")
    }

    do {
        print("Seleccione un índice: ")
        index = readlnOrNull()?.toIntOrNull()

        if (index !in users.indices) {
            println("ERROR. Ingrese un indice válido.")
        }

    } while (index !in users.indices)

    println("-----------------------------------")
    users[index!!].showData()
    println("-----------------------------------")
}

fun menu(users: MutableList<User>) {
    var exit = false
    var option : Int?

    do {
        println(
            "1. Ingresar usuario. \n" +
                    "2. Mostrar usuario. \n" +
                    "3. Salir."
        )
        print("Opción: ")
        option = readlnOrNull()?.toIntOrNull()

        if (option == null) {
            println("ERROR. Ingrese una opción permitida.")
        } else {
            when (option) {
                1 -> users.add(createUser(users.toList()))

                2 -> if (users.isEmpty()) println("No hay usuarios registrados.") else showUser(users)

                3 -> exit = true

                else -> println("ERROR. Ingrese una opción permitida.")
            }
        }

    } while (!exit)
    println("\nbai.")
}