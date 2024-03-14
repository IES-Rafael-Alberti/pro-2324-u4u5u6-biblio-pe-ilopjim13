package org.pebiblioteca

import java.util.*

class Usuario(val nombre:String) {
    val idUsu: String = UtilidadesBiblioteca.generarIdentificadorUnico()
    val librosPrestados = mutableListOf<Elemento>()
    companion object {
        var ident = 0
    }
}