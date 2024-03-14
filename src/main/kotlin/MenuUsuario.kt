package org.pebiblioteca

/**
 * Menu con el que el usuari va a poder interactuar con el programa
 */
class MenuUsuario {

    companion object{
        /**
         * Muestra el menu de lo que puede hacer el usuario
         * @param usuario: Usuario usuario que va a interactuar con el programa
         * @param gestor: el gestor de la gestion de la biblioteca
         */
        fun mostrarMenu(usuario: Usuario, gestor: GestionBiblioteca) {
            do {
                println("1. Agregar Libro")
                println("2. Eliminar Libro")
                println("3. Prestar libro")
                println("4. Devolver Libro")
                println("5. Consultar Disponibilidad")
                println("6. Consultar Registro")
                println("7. Salir")
                println()

                val opcion = pedirOpcion()

                ejecutarMenu(opcion, gestor, usuario)
            } while (opcion != 7)

        }

        /**
         * Pide una opcion y devuelve esa opcion
         * @return devuelve el numero de la opcion
         */
        private fun pedirOpcion(): Int {
            var opcion = -1
            do {
                try {
                    print(">> Selecciona una opción: ")
                    opcion = readln().toInt()
                    if (opcion !in (1..7)) {
                        println("Error la opción no es correcta")
                        opcion = -1
                    }
                } catch (e: NumberFormatException) {
                    println("ERROR La opción debe de ser un número correcto")
                }
            } while (opcion < 0)
            return opcion
        }

        /**
         * ejecuta las opciones del menu
         * @param opcion :Int opcion de lo que quiere hacer
         * @param gestor: GestionBiblioteca el gestor de la gestion de la biblioteca
         * @param usuario: Usuario usuario que va a interactuar con el programa
         */
        private fun ejecutarMenu(opcion: Int, gestor: GestionBiblioteca, usuario: Usuario) {
            when (opcion) {
                1 -> agregar(gestor)
                2 -> eliminar(gestor)
                3 -> prestamo(usuario, gestor)
                4 -> devolver(usuario, gestor)
                5 -> consultarDisponibilidad(gestor)
                6 -> consultarRegistro(gestor)
            }
        }

        /**
         * Agrega un elemento a la gestion de la biblioteca
         * @param gestor: GestionBiblioteca el gestor de la gestion de la biblioteca
         */
        private fun agregar(gestor: GestionBiblioteca) {
            var anio: Int = -1
            print("\nIntroduce el titulo del libro: ")
            val titulo = readln()
            print("Introduce el autor del libro: ")
            val autor: String = readln()
            do {
                try {
                    print("Introduce el año de publicacion del libro: ")
                    anio = readln().toInt()
                } catch (e: NumberFormatException) {
                    println("ERROR el año introducido debe ser correcto")
                }
            } while (anio < 0)

            print("Introduce la tematica del libro: ")
            val tematica = readln()
            if (gestor.agregarElemento(titulo, autor, anio, tematica)) println("Libro añadido a la biblioteca")
            else println("No se ha podido añadir le libro a la biblioteca.")
        }

        /**
         * Elimina un elemento a la gestion de la biblioteca
         * @param gestor: GestionBiblioteca el gestor de la gestion de la biblioteca
         */
        private fun eliminar(gestor: GestionBiblioteca) {
            gestor.catalogo.lista.forEach {
                println("${it.titulo} con id: ${it.id}")
            }
            print("\nIntroduce el Id del libro a eliminar: ")
            val id = readln()
            if (gestor.eliminarElemento(id)) println("Libro eliminado de la biblioteca")
            else println("No se ha podido eliminar el libro de la biblioteca")
        }

        /**
         * Da un prestamo de un elemento a un usuario
         * @param gestor: GestionBiblioteca el gestor de la gestion de la biblioteca
         * @param usuario: Usuario usuario que va a interactuar con el programa
         */
        private fun prestamo(usuario: Usuario, gestor: GestionBiblioteca) {
            gestor.catalogo.lista.forEach {
                println("${it.titulo} con id: ${it.id}")
            }
            print("\nIntroduce el Id del libro a prestar: ")
            val id = readln()
            if (gestor.registrarPrestamo(usuario, id)) println("Libro prestado")
            else println("No se ha podido prestar el libro")
        }

        /**
         * Devuelve un elemento de un usuario
         * @param gestor: GestionBiblioteca el gestor de la gestion de la biblioteca
         * @param usuario: Usuario usuario que va a interactuar con el programa
         */
        private fun devolver(usuario: Usuario, gestor: GestionBiblioteca) {
            gestor.catalogo.lista.forEach {
                println("${it.titulo} con id: ${it.id}")
            }
            print("\nIntroduce el Id del libro a devolver: ")
            val id = readln()
            if (gestor.registrarDevolucion(usuario, id)) println("Libro devuelto")
            else println("No se ha podido devolver el libro")
        }

        /**
         * Consulta la disponibillidad de los elementos de la gestion de biblioteca
         * @param gestor: GestionBiblioteca el gestor de la gestion de la bibliotecama
         */
        private fun consultarDisponibilidad(gestor: GestionBiblioteca) {
            gestor.catalogo.lista.forEach {
                println("${it.titulo} con id: ${it.id}")
            }
            print("\nIntroduce el Id del libro a consultar: ")
            val id = readln()
            if(gestor.consultarDisponibilidad(id)) println("Está disponible")
            else println("No está disponible")
        }

        /**
         * Consulta los registros del gestor de biblioteca
         * @param gestor: GestionBiblioteca el gestor de la gestion de la bibliotecama
         */
        private fun consultarRegistro(gestor: GestionBiblioteca) {
            print("\nIntroduce el Id del libro o del usuario para ver sus registros: ")
            val id = readln()
            val historial = gestor.registros.consultarHistorial(id)
            historial.forEach { println(it) }
        }
    }

}