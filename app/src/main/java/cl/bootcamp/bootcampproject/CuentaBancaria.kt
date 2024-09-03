package cl.bootcamp.bootcampproject

class CuentaBancaria(
    private val nombreCuenta : String,
    private var saldoDisponible : Double) {

    private val transacciones : MutableList<String> = mutableListOf()

    fun deposito(dinero : Double) {
        saldoDisponible += dinero
        transacciones.add("$nombreCuenta depositó $dinero")
    }

    fun retiro(dinero : Double) : Boolean{
        if (saldoDisponible >= dinero) {
            saldoDisponible -= dinero
            transacciones.add("$nombreCuenta retiró $dinero")
            return true
        } else {
            return false
        }
    }

    fun mostrarSaldo() {
        println("---------------------------------------------------")
        println("$nombreCuenta. Su saldo disponible es $$saldoDisponible")
        println("---------------------------------------------------")
    }

    fun mostrarHistorial() {
        println("---------------------------------------------------")
        println("Historial de transacciones - $nombreCuenta")
        println("---------------------------------------------------")
        transacciones.forEach { println(it) }
        println("---------------------------------------------------")
    }

    fun getNombre() : String {
        return nombreCuenta    }
}