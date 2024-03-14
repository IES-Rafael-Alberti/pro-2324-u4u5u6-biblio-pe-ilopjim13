package org.pebiblioteca

import java.util.*

class Usuario(val nombre:String) {
    val idUsu: String = UtilidadesBiblioteca.generarIdentificadorUnico()
    val librosPrestados = mutableListOf<Elemento>()
    companion object {
        var ident = 0
    }

    fun agregarLibros(libro:Elemento) {
        if (libro !in librosPrestados) librosPrestados.add(libro)
    }

    fun eliminarLibro(libro: Elemento) {
        librosPrestados.remove(libro)
    }

    fun mostrarLibrosPrestados() {
        librosPrestados.forEach { println(it) }
    }

}