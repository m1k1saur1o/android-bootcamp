package cl.bootcamp.bootcampproject

fun main() {
    val cuentas : MutableList<CuentaBancaria> = mutableListOf()
    menu(cuentas)
}

fun menu(cuentas : MutableList<CuentaBancaria>) {
    var exit = false
    var option : Int?

    do {
        println(
            "1. Crear cuenta. \n" +
                    "2. Seleccionar cuenta. \n" +
                    "3. Salir. \n"
        )
        print("Opción: ")
        option = readlnOrNull()?.toIntOrNull()

        if (option == null) {
            println("ERROR. Ingrese una opción permitida.")
        } else {
            when (option) {
                1 -> crearCuenta(cuentas)

                2 -> {
                    if (cuentas.isEmpty()) {
                        println("---------------------------------------------------")
                        println("No hay cuentas en el sistema.")
                        println("---------------------------------------------------")
                    } else {
                        menuCuenta(seleccionarCuenta(cuentas.toList()))
                    }
                }

                3 -> exit = true

                else -> println("ERROR. Ingrese una opción permitida.")
            }
        }

    } while (!exit)
    println("\nbai.")
}

fun crearCuenta(cuentas : MutableList<CuentaBancaria>) {
    var nombreCuenta : String?
    var saldoCuenta : Double?

    do {
        println("---------------------------------------------------")
        print("Ingrese el nombre de la cuenta: ")
        nombreCuenta = readlnOrNull()
        if (nombreCuenta.isNullOrEmpty()) nombreCuenta = null

        print("Ingrese el saldo de la cuenta: ")
        saldoCuenta = readlnOrNull()?.toDoubleOrNull()

        if (nombreCuenta == null || saldoCuenta == null || saldoCuenta < 0) {
            println("---------------------------------------------------")
            println("ERROR. Debe ingresar un nombre de cuenta y saldo de cuenta")
        }
    } while (nombreCuenta == null || saldoCuenta == null || saldoCuenta < 0)
    println("---------------------------------------------------")

    cuentas.add(CuentaBancaria(nombreCuenta = nombreCuenta, saldoDisponible = saldoCuenta))
    println("$nombreCuenta agregad@ correctamente.")
    println("---------------------------------------------------")
}

fun seleccionarCuenta(cuentas : List<CuentaBancaria>) : CuentaBancaria {
    var index : Int?
    println("---------------------------------------------------")
    cuentas.forEachIndexed { i, cuentaBancaria ->
        println("Índice: $i | Cuenta: ${cuentaBancaria.getNombre()}")
    }
    println("---------------------------------------------------")
    do {
        print("Seleccione un usuario: ")
        index = readlnOrNull()?.toIntOrNull()

        if (index !in cuentas.indices) {
            println("ERROR. ingrese un índice válido")
        }
    } while (index !in cuentas.indices)
    println("---------------------------------------------------")
    return cuentas[index!!]
}

fun menuCuenta (cuenta : CuentaBancaria) {
    var exit = false
    var option : Int?

    do {
        println(
            "1. Deposito. \n" +
                    "2. Retiro. \n" +
                    "3. Mostrar saldo. \n" +
                    "4. Mostrar historial. \n" +
                    "5. Salir. \n"
        )
        print("Opción: ")
        option = readlnOrNull()?.toIntOrNull()

        if (option == null) {
            println("ERROR. Ingrese una opción permitida.")
        } else {
            when (option) {
                1 -> realizarDeposito(cuenta)

                2 -> realizarRetiro(cuenta)

                3 -> cuenta.mostrarSaldo()

                4 -> cuenta.mostrarHistorial()

                5 -> exit = true

                else -> println("ERROR. Ingrese una opción permitida.")
            }
        }

    } while (!exit)
    println("---------------------------------------------------")
}

fun realizarDeposito(cuenta : CuentaBancaria) {
    var dinero : Double?
    println("---------------------------------------------------")
    do {
        print("Ingrese la cantidad del deposito: ")
        dinero = readlnOrNull()?.toDoubleOrNull()

        if (dinero == null || dinero <= 0) {
            println("ERROR. ingrese una cantidad válida.")
        }

    } while (dinero == null || dinero <= 0)

    cuenta.deposito(dinero)
    println("---------------------------------------------------")
    println("Operación realizada con éxito")
    println("---------------------------------------------------")
}

fun realizarRetiro(cuenta : CuentaBancaria) {
    var dinero : Double?

    do {
        print("Ingrese la cantidad del retiro: ")
        dinero = readlnOrNull()?.toDoubleOrNull()

        if (dinero == null || dinero <= 0) {
            println("ERROR. ingrese una cantidad válida.")
        }

    } while (dinero == null || dinero <= 0)

    if (cuenta.retiro(dinero)) {
        println("---------------------------------------------------")
        println("Retiro exitoso.")
        println("---------------------------------------------------")
    } else {
        println("---------------------------------------------------")
        println("ERROR. Saldo insuficiente.")
        println("---------------------------------------------------")
    }
}