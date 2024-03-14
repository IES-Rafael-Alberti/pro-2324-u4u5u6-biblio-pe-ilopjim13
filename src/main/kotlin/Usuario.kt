package org.pebiblioteca

import java.util.*

data class Usuario(val idUsu: String = UUID.randomUUID().toString(), val nombre:String) {
    val librosPrestados = mutableListOf<Libro>()
    companion object {
        var ident = 0
    }
}