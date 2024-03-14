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

        //ejecutarMenu(opcion)

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

//    private fun ejecutarMenu(opcion :Int, gestor:GestionBiblioteca) {
//        when (opcion) {
//            1->  agregar(gestor)
//            2->  eliminar(gestor)
//            3 -> GestionBiblioteca.registrarPrestamo(usuario, id)
//            4 -> GestionBiblioteca.registrarDevolucion(usuario, id)
//            5 -> GestionBiblioteca.consultarDisponibilidad(id)
//            6 -> GestionBiblioteca.registros.consultarRegistros(id)
//        }
//    }

    fun agregar(gestor:GestionBiblioteca) {
        var anio:Int = -1
        println("Introduce el titulo del libro: ")
        val titulo = readln()
        println("Introduce el autor del libro: ")
        val autor:String = readln()
        do {
            try {
                println("Introduce el año de publicacion del libro: ")
                anio = readln().toInt()
            } catch (e: NumberFormatException) {
                println("ERROR el año introducido debe ser correcto")
            }
        } while (anio > 0)

        println("Introduce la tematica del libro: ")
        val tematica = readln()
        gestor.agregarElemento(titulo, autor, anio, tematica)

    }

    fun eliminar(gestor: GestionBiblioteca) {
        gestor.catalogo.lista.forEach{
            println("${it.titulo} con id: ${it.id}")
        }
        println("Introduce el Id del libro a eliminar")
        val id = readln()
        gestor.eliminarElemento(id)
    }

}