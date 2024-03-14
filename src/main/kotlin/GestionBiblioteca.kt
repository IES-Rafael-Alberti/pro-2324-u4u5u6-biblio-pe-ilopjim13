package org.pebiblioteca

import java.util.*

/**
 * Clase principal de nuestro sistema, se encarga de la lógica para gestionar libro y otros elementos,
 * @property registros: IGestorPrestamos interfaz
 * @property catalogo: IGestorCatalogo
 */
class GestionBiblioteca(val registros:IGestorPrestamos, val catalogo: IGestorCatalogo) {


        fun agregarElemento(libro:ElementoBiblioteca):Boolean {
            return if (catalogo.agregarElemento(libro)) true
            else false
        }


        fun eliminarElemento(id: String):Boolean {
            val libro = catalogo.lista.find { it.id == id }
            return if(libro != null) {
                if (catalogo.eliminarElemento(libro)) true
                else false
            } else false
        }

        fun registrarPrestamo(usuario: Usuario, idLibro: String):Boolean {
            val libro = catalogo.lista.find { it.id == idLibro }
            return if (libro != null && libro.estado == Estado.DISPONIBLE) {
                usuario.agregarLibros(libro)
                registros.registrarPrestamo(usuario, libro)
                libro.prestar()
                true
            } else false
        }

        fun registrarDevolucion(usuario: Usuario, idLibro: String):Boolean {
            val libro = catalogo.lista.find { it.id == idLibro }
            return if (libro != null && libro.estado == Estado.PRESTADO) {
                usuario.eliminarLibro(libro)
                registros.registrarDevolucion(usuario, libro)
                libro.devolver()
                true
            } else false
        }

        fun consultarDisponibilidad(id: String): Boolean {
            val libro = catalogo.lista.find { it.id == id }
            return if (libro != null) libro.estado == Estado.DISPONIBLE
            else false
        }

        fun mostrarTodos():List<ElementoBiblioteca> {
            return catalogo.lista
        }

        fun mostrarDisponibles() :List<ElementoBiblioteca> {
            return catalogo.lista.filter { it.estado == Estado.DISPONIBLE }
        }

        fun mostrarPresatados() :List<ElementoBiblioteca> {
            return catalogo.lista.filter { it.estado == Estado.PRESTADO }
        }
}