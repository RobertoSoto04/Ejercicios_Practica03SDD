// Principio Sólido
/*
1. Single Responsability Principle (SRP) - Principio de responsabilidad Unica 
*/

//Ejemplo de no uso de SRP
/*
class factura(val items: List<Item>){
    fun calcularTotal(): Double{
        return items.sumOf {it.precio}
    }

    fun generarReporte(): String{
        return "Reporte de la factura"
    }

}
*/

//
class Factura(){
    fun calcularTotal(): String{
        return "Este es el total"
    }
}

class ReporteFactura { 
    fun generar(factura: Factura): String{
        return "reporte d ela factura"
    }
}

/*
2. Open/Close Principle (OCP) - Principio Abierto/Cerrado
*/

open class Empleado (val nombre: String, val horasTrabajadas: Int, val preciHora: Double){
    open fun calcularSalario(): Double{
        return horasTrabajadas*preciHora
    }
}

Class EmpleadoConBono(nombre: String, horasTrabajadas: Int, preciHora: Double, val bono: Double):Empleado(nombre, horasTrabajadas, preciHora){
    override fun calcularSalario(): Double{
        return super.calcularSalario() + bono
    }
}

/*
3. Liskov Substitution Principle (LSP) - Principio de sustitucion Liskov
*/

fun main(args: Array<String>) {
    fun imprimirSalario(empleado: Empleado){
        println("El salario de ${empleado.nombre} es de ${empleado.calcularSalario()}")
    }

    val empleado = Empleado("Daniel", 40, 12.0)
    val empleadoConBono = EmpleadoConBono("Fernanda", 40, 12.0, 70.0)

    imprimirSalario(empleado)
    imprimirSalario(empleadoConBono)

}

/*
4. Interface Segregation Principle (ISP) - Principio de Segregacion de Interfaces 
*/
interface Trabajador{
    fun trabajar()
}

interface Asistente{
    fun asistir()
}

interface Reportero{
    fun generarReporte()
} 

class Programador: Trabajador {
    overrride fun trabajar(){
        println("El programador está programando")
    }
}

class Albanil: Trabajador {
    override fun trabajar(){
        //agragar de tabajo 
    }
}

/*
5. Dependency Inversion Principle (DIP) - Principio de Inversion de dependencias
*/

interface Notificaciones{
    fun enviarNotifcacion(mensaje: String) 
}

class ServicioEmail:Notificaciones{
    override fun enviarNotificacion(mensaje: String){
        println("Enviando Email: $mensaje")
    }
}

class Notificacion(val servicio:Notificaciones){
    fun enviarUnaNotificacion(){
        servicio.enviarNotificacion("Notificacion Importante")
    }
}
