package org.pebiblioteca

class MenuUsuario {

    fun mostrarMenu() {
        println("1. Agregar Libro")
        println("2. Eliminar Libro")
        println("3. Prestar libro")
        println("4. Devolver Libro")
        println("5. Consultar Disponibilidad")
        println("6. Consultar Registro")
        println("7. Salir")

        val opcion = pedirOpcion()

        ejecutarMenu(opcion)

    }

    private fun pedirOpcion():Int {
        var opcion = -1
        do {
            try {
                println(">> Selecciona una opción: ")
                opcion = readln().toInt()
                if(opcion !in (1..7)) {
                    println("Error la opción no es correcta")
                    opcion = -1
                }
            } catch (e:NumberFormatException) {
                println("ERROR La opción debe de ser un número correcto")
            }
        } while (opcion > 0)
        return opcion
    }

    private fun ejecutarMenu(opcion :Int) {
        when (opcion) {
            1->  GestionBiblioteca.agregarElemento(libro)
            2->  GestionBiblioteca.eliminarElemento(id)
            3 -> GestionBiblioteca.registrarPrestamo(usuario, id)
            4 -> GestionBiblioteca.registrarDevolucion(usuario, id)
            5 -> GestionBiblioteca.consultarDisponibilidad(id)
            6 -> GestionBiblioteca.registros.consultarRegistros(id)
        }
    }

}