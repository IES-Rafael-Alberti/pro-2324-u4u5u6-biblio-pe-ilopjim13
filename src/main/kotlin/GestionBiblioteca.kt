package org.pebiblioteca

import java.util.*

class GestionBiblioteca {

        val catalogo = Catalogo<Elemento>()
        val registros = RegistroPrestamos()

        fun agregarElemento(titulo:String, autor:String, anio:Int, tematica:String) {
            try {
                catalogo.lista.add(Libro(titulo, autor, anio, tematica, UtilidadesBiblioteca.generarIdentificadorUnico()))
            } catch (e : IllegalArgumentException) {
                println(e)
            }
        }


        fun eliminarElemento(id: String): Boolean {
            val libro = catalogo.lista.find { it.id == id }
            return if (libro in catalogo.lista) {
                catalogo.lista.remove(libro)
                true
            } else false
        }

        fun registrarPrestamo(usuario: Usuario, idLibro: String) {
            val libro = catalogo.lista.find { it.id == idLibro }
            if (libro != null && libro.estado == Estado.DISPONIBLE) {
                usuario.librosPrestados.add(libro)
                if (usuario in registros.prestamosActuales) registros.prestamosActuales[usuario]?.add(libro)
                else registros.prestamosActuales[usuario] = mutableListOf(libro)
                registros.historial.add("${usuario.nombre} con id ${usuario.idUsu} ha tomado prestado el libro ${libro.titulo}")
                registros.historial.add("${libro.titulo} con id ${libro.id} ha sido tomado por ${usuario.nombre}")
                libro.estado = Estado.PRESTADO
                println("Libro prestado")
            } else println("Este libro no está disponible")
        }

        fun registrarDevolucion(usuario: Usuario, idLibro: String) {
            val libro = catalogo.lista.find { it.id == idLibro }
            if (libro != null && libro.estado == Estado.PRESTADO) {
                usuario.librosPrestados.remove(libro)
                if (usuario in registros.prestamosActuales) registros.prestamosActuales[usuario]?.remove(libro)
                registros.historial.add("${usuario.nombre} con id ${usuario.idUsu} ha devuelto el libro ${libro.titulo}")
                registros.historial.add("${libro.titulo} con id ${libro.id} ha sido devuelto por ${usuario.nombre}")
                libro.estado = Estado.DISPONIBLE
                println("Libro devuelto")
            } else println("Este libro no ha sido prestado")
        }

        fun consultarDisponibilidad(id: String): Boolean {
            val libro = catalogo.lista.find { it.id == id }
            return if (libro != null) libro.estado == Estado.DISPONIBLE
            else false
        }

        fun mostrarTodos():List<Elemento> {
            return catalogo.lista
        }

        fun mostrarDisponibles() :List<Elemento> {
            return catalogo.lista.filter { it.estado == Estado.DISPONIBLE }
        }

        fun mostrarPresatados() :List<Elemento> {
            return catalogo.lista.filter { it.estado == Estado.PRESTADO }
        }
}