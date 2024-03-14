package org.pebiblioteca

import java.util.*

class GestionBiblioteca {
    companion object {
        val catalogo = Catalogo<Libro>()
        val registros = RegistroPrestamos()

        fun agregarElemento(libro: Libro): Boolean {
            return if (libro !in catalogo.lista) {
                catalogo.lista.add(libro)
                true
            } else false
        }

        fun eliminarElemento(id: String): Boolean {
            val libro = catalogo.lista.find { it.idLibro == id }
            return if (libro in catalogo.lista) {
                catalogo.lista.remove(libro)
                true
            } else false
        }

        fun registrarPrestamo(usuario: Usuario, idLibro: String) {
            val libro = catalogo.lista.find { it.idLibro == idLibro }
            if (libro != null) {
                usuario.librosPrestados.add(libro)
                if (usuario in registros.prestamosActuales) registros.prestamosActuales[usuario]?.add(libro)
                else registros.prestamosActuales[usuario] = mutableListOf(libro)
                registros.historial.add("${usuario.nombre} con id ${usuario.idUsu} ha tomado prestado el libro ${libro.titulo}")
                registros.historial.add("${libro.titulo} con id ${libro.idLibro} ha sido tomado por ${usuario.nombre}")
            }
        }

        fun registrarDevolucion(usuario: Usuario, idLibro: String) {
            val libro = catalogo.lista.find { it.idLibro == idLibro }
            if (libro != null) {
                usuario.librosPrestados.remove(libro)
                if (usuario in registros.prestamosActuales) registros.prestamosActuales[usuario]?.remove(libro)
                registros.historial.add("${usuario.nombre} con id ${usuario.idUsu} ha devuelto el libro ${libro.titulo}")
                registros.historial.add("${libro.titulo} con id ${libro.idLibro} ha sido devuelto por ${usuario.nombre}")
            }
        }

        fun consultarDisponibilidad(id: String): Boolean {
            val libro = catalogo.lista.find { it.idLibro == id }
            return if (libro != null) libro.estado == Estado.DISPONIBLE
            else false
        }
    }
}